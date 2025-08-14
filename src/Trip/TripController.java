package Trip;

import java.util.List;

public class TripController {
    private TripView tripView;
    private TripService tripService;

    public TripController(TripView tripView, TripService tripService) {
        this.tripView = tripView;
        this.tripService = tripService;
    }

    public void createTrip() {
        TripModel tripInput = tripView.inputTripInfo();

        TripModel savedTrip = tripService.createTrip(
                tripInput.getTripName(),
                tripInput.getStartDate(),
                tripInput.getEndDate()
        );

        tripService.saveTripToJson(savedTrip);
    }

    public void showAllTrips() {
        List<TripModel> trips = tripService.getAllTrips();
        tripView.printTripList(trips);
    }
}
