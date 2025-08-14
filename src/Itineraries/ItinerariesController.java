package Itineraries;

public class ItinerariesController {
    private final ItinerariesView itinerariesView;
    private final AccommodationController accommodationController;
    private final MoveController moveController;

    public ItinerariesController(ItinerariesView itinerariesView,
                                 AccommodationController accommodationController,
                                 MoveController moveController) {
        this.itinerariesView = itinerariesView;
        this.accommodationController = accommodationController;
        this.moveController = moveController;
    }

    public void run() {
        itinerariesView.printWelcomeMessage();
        String tripId = itinerariesView.ask TripId();

        while (itinerariesView.askYesNo("여정을 입력하시겠습니까?")) {
            String type = itinerariesView.askItineraryType();

            switch (type) {
                default -> itinerariesView.showInvalidType();
            }
        }
    }
}
