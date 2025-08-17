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
                tripInput.getTripId(),
                tripInput.getTripName(),
                tripInput.getStartDate(),
                tripInput.getEndDate()
        );

        tripService.saveTripToJson(savedTrip);
    }

    public void showTripsAndDetails() {
        List<TripModel> trips = tripService.getAllTrips();
        tripView.printTripList(trips);

        String tripId = tripView.inputTripId();

        TripModel trip = tripService.getTripById(tripId);
        if (trip == null) {
            System.out.println("해당 ID의 여행이 존재하지 않습니다.");
        } else {
            tripView.printTripDetails(trip);
        }
    }
}
