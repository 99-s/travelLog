package Trip;

import Itineraries.ItinerariesRepository;
import Itineraries.Itinerary;

import java.util.List;

public class TripService {
    private TripRepository tripRepository;
    private ItinerariesRepository itinerariesRepository;

    public TripService(TripRepository tripRepository, ItinerariesRepository itinerariesRepository) {
        this.tripRepository = tripRepository;
        this.itinerariesRepository = itinerariesRepository;
    }

    public TripModel createTrip(String tripId, String title, String startDate, String endDate) {
        return tripRepository.save(tripId, title, startDate, endDate);
    }

    public void saveTripToJson(TripModel trip) {
        tripRepository.saveTripAsJson(trip);
    }

    public void addItinerary(Itinerary itinerary) {
        itinerariesRepository.save(itinerary);  // 여정 저장은 이쪽에서 처리
    }

    public List<TripModel> getAllTrips() {
        return tripRepository.findAll();
    }

    public TripModel getTripById(String tripId) {
        return tripRepository.findById(tripId);
    }
}
