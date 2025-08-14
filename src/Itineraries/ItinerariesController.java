package Itineraries;

import AccommodationInfo.AccommodationController;
import MoveInfo.MoveInfoController;
import MoveInfo.MoveItinerary;

import java.util.List;

public class ItinerariesController {
    private final ItinerariesView itinerariesView;
    private final AccommodationController accommodationController;
    private final MoveInfoController moveInfoController;
    private final ItinerariesService itinerariesService;
    private MoveItinerary moveItinerary;

    public ItinerariesController(ItinerariesView itinerariesView,
                                 AccommodationController accommodationController,
                                 MoveInfoController moveInfoController, ItinerariesService itinerariesService) {
        this.itinerariesView = itinerariesView;
        this.accommodationController = accommodationController;
        this.moveInfoController = moveInfoController;
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
            itinerariesView.printItineraries(tripId);
        }
    }

    public void recordItineraries() {
        itinerariesView.printWelcomeMessage();
        String tripId = itinerariesView.askTripId();

        while (itinerariesView.askYesNo("여정을 입력하시겠습니까?")) {
            String type = itinerariesView.askItineraryType();

            switch (type) {
                // 이거
//                case "A" -> accommodationController.(tripId);
                case "M" -> {
                    moveItinerary = moveInfoController.moveInfoControllerRun(tripId);
                    itinerariesService.saveItinerary(moveItinerary);
                }
                default -> itinerariesView.showInvalidType();
            }
        }
    }
}
