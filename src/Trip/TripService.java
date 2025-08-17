package Trip;

import java.util.List;

public class TripService {
    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripModel createTrip(String tripId, String title, String startDate, String endDate) {
        return tripRepository.save(tripId, title, startDate, endDate);
    }

    public void saveTripToJson(TripModel trip) {
        tripRepository.saveTripAsJson(trip);
    }

    public List<TripModel> getAllTrips() {
        return tripRepository.findAll();
    }

    public TripModel getTripById(String tripId) {
        return tripRepository.findById(tripId);
    }

}
