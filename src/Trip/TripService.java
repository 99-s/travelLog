package Trip;

public class TripService {
    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripModel createTrip(String title, String startDate, String endDate) {
        return tripRepository.save(title, startDate, endDate);
    }

    public void saveTripToJson(TripModel trip) {
        tripRepository.saveTripAsJson(trip);
    }

}
