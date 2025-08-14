package Itineraries;

import AccommodationInfo.AccommodationController;
import AccommodationInfo.AccommodationInfoView;
import AccommodationInfo.AccommodationItinerary;
import MoveInfo.MoveInfoController;
import MoveInfo.MoveInfoView;
import MoveInfo.MoveItinerary;

import java.util.List;

public class ItinerariesController {
    private final ItinerariesView itinerariesView;
    private final AccommodationController accommodationController;
    private final MoveInfoController moveInfoController;
    private final ItinerariesService itinerariesService;
    private MoveItinerary moveItinerary;
    private MoveInfoView moveInfoView;
    private AccommodationItinerary accommodationItinerary;
    private AccommodationInfoView accommodationInfoView;

    public ItinerariesController(ItinerariesView itinerariesView,
                                 AccommodationController accommodationController,
                                 MoveInfoController moveInfoController,
                                 AccommodationInfoView accommodationInfoView,
                                 MoveInfoView moveInfoView,
                                 ItinerariesService itinerariesService) {
        this.itinerariesView = itinerariesView;
        this.accommodationController = accommodationController;
        this.moveInfoController = moveInfoController;
        this.accommodationInfoView = accommodationInfoView;
        this.moveInfoView = moveInfoView;
        this.itinerariesService = itinerariesService;
    }


    //여정조회
    public void showAllItineraries() {
        String tripId = itinerariesView.askTripId(); // 조회할 여행 ID 입력
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
        String tripId = itinerariesView.askTripId();

        while (itinerariesView.askYesNo("여정을 입력하시겠습니까?")) {
            String type = itinerariesView.askItineraryType();

            switch (type) {
                case "M" -> {
                    MoveItinerary moveItinerary = moveInfoView.inputMoveInfo(tripId);
                    if (moveItinerary != null) {
                        itinerariesService.saveItinerary(moveItinerary);
                    } else {
                        System.out.println("이동 정보 입력이 취소되었습니다.");
                    }
                }
                case "A" -> {
                    // 숙박 정보도 inputAccommodationInfo(tripId) 식으로 처리할 수 있다고 가정
                    AccommodationItinerary accommodationItinerary = accommodationInfoView.inputAccommodationInfo(tripId);
                    if (accommodationItinerary != null) {
                        itinerariesService.saveItinerary(accommodationItinerary);
                    } else {
                        System.out.println("숙박 정보 입력이 취소되었습니다.");
                    }
                }
                default -> itinerariesView.showInvalidType();
            }
        }
    }
}
