package Trip;

public class TripController {
    private TripView tripView;
    private TripService tripService;

    public TripController(TripView tripView, TripService tripService) {
        this.tripView = tripView;
        this.tripService = tripService;
    }

    public void createTrip() {
        TripModel tripInput = tripView.inputTripInfo();

        tripService.createTrip(
                tripInput.getTripName(),
                tripInput.getStartDate(),
                tripInput.getEndDate()
        );

        tripService.saveTripsToJson("trips.json");
    }
}
