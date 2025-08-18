package Itineraries;

import AccommodationInfo.AccommodationInfoController;
import AccommodationInfo.AccommodationInfoView;
import MoveInfo.MoveInfoController;
import MoveInfo.MoveInfoView;
import utils.StringValidator;
import Trip.TripService;

import java.util.List;

public class ItinerariesController {
    private final ItinerariesView itinerariesView;
    private final AccommodationInfoController accommodationInfoController;
    private final MoveInfoController moveInfoController;
    private final ItinerariesService itinerariesService;
    private final AccommodationInfoView accommodationInfoView;
    private final MoveInfoView moveInfoView;
    private final TripService tripService;

    public ItinerariesController(ItinerariesView itinerariesView,
                                 AccommodationInfoController accommodationInfoController,
                                 MoveInfoController moveInfoController,
                                 AccommodationInfoView accommodationInfoView,
                                 MoveInfoView moveInfoView,
                                 ItinerariesService itinerariesService,
                                 TripService tripService) {
        this.itinerariesView = itinerariesView;
        this.accommodationInfoController = accommodationInfoController;
        this.moveInfoController = moveInfoController;
        this.accommodationInfoView = accommodationInfoView;
        this.moveInfoView = moveInfoView;
        this.itinerariesService = itinerariesService;
        this.tripService = tripService;
    }

    public void showAllItineraries() {
        String tripId = getValidatedTripId();
        if (tripId == null) return;

        List<Itinerary> itineraries = itinerariesService.getItinerariesByTrip(tripId);

        if (itineraries.isEmpty()) {
            System.out.println("해당 여행의 여정이 없습니다.");
        } else {
            System.out.println("=== " + tripId + " 여행의 여정 목록 ===");
            itinerariesView.printItineraries(tripId,itineraries);
        }
    }

    public void recordItineraries() {
        itinerariesView.printWelcomeMessage();
        String tripId = getValidatedTripId();
        if (tripId == null) return;

        while (itinerariesView.askYesNo("여정을 입력하시겠습니까?")) {
            String type = itinerariesView.askItineraryType();

            switch (type) {
                case "A" -> recordAccommodationItinerary(tripId);
                case "M" -> recordMoveItinerary(tripId);
                default -> itinerariesView.showInvalidType();
            }
        }
    }

    private void recordAccommodationItinerary(String tripId) {
        Itinerary accommodationItinerary = accommodationInfoView.inputAccommodationInfo(tripId);
        if (accommodationItinerary != null) {
            itinerariesService.saveItinerary(accommodationItinerary);
        }
    }

    private void recordMoveItinerary(String tripId) {
        Itinerary moveItinerary = moveInfoView.inputMoveInfo(tripId);
        if (moveItinerary != null) {
            itinerariesService.saveItinerary(moveItinerary);
        }
    }

    private String getValidatedTripId() {
        while (true) {
            try {
                String tripId = itinerariesView.askTripId();
                StringValidator.validateNotEmpty(tripId, "여행 ID");

                // 여행 ID가 실제로 존재하는지 검증
                if (tripService.getTripById(tripId) == null) {
                    throw new IllegalArgumentException("존재하지 않는 여행 ID입니다. 먼저 여행을 생성해주세요.");
                }

                return tripId;
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
                if (!itinerariesView.askYesNo("다시 입력하시겠습니까?")) {
                    return null;
                }
            }
        }
    }
}
