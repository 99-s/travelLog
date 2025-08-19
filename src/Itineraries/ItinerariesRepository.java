package Itineraries;

import Trip.TripModel;
import Trip.TripRepository;

import java.util.*;

public class ItinerariesRepository {
    private Map<String, List<Itinerary>> db = new HashMap<>();
    private TripRepository tripRepository;

    public ItinerariesRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // 여정 저장 (Trip에도 반영 + JSON 저장)
    public void save(Itinerary itinerary) {
        String tripId = itinerary.getTripId();

        // 메모리 DB 저장
        db.computeIfAbsent(tripId, k -> new ArrayList<>()).add(itinerary);

        // TripRepository 반영
        TripModel trip = tripRepository.findById(tripId);
        if (trip != null) {
            trip.getItineraries().add(itinerary);
            System.out.println(trip.getItineraries());
            tripRepository.saveTripAsJson(trip);
        }
    }

    public List<Itinerary> findAll(String tripId) {
        return db.getOrDefault(tripId, new ArrayList<>());
    }
}
