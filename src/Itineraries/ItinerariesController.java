package Itineraries;

import AccommodationInfo.AccommodationController;
import MoveInfo.MoveInfoController;

public class ItinerariesController {
    private final ItinerariesView itinerariesView;
    private final AccommodationController accommodationController;
    private final MoveInfoController moveInfoController;

    public ItinerariesController(ItinerariesView itinerariesView,
                                 AccommodationController accommodationController,
                                 MoveInfoController moveInfoController) {
        this.itinerariesView = itinerariesView;
        this.accommodationController = accommodationController;
        this.moveInfoController = moveInfoController;
    }

    public void run() {
        itinerariesView.printWelcomeMessage();
        String tripId = itinerariesView.askTripId();

        while (itinerariesView.askYesNo("여정을 입력하시겠습니까?")) {
            String type = itinerariesView.askItineraryType();

            switch (type) {
                // 이거
//                case "A" -> accommodationController.inputAccommodation(tripId);
//                case "M" -> moveInfoController.inputMove(tripId);
                default -> itinerariesView.showInvalidType();
            }
        }
    }
}
