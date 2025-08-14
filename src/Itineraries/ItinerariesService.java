package Itineraries;

import java.util.List;

public class ItinerariesService {
    private ItinerariesRepository repository;

    public ItinerariesService(ItinerariesRepository repository)
    {
        this.repository = repository;
    }
    // 특정 여행(trip)에 속한 모든 여정 조회
    public List<Itinerary> getItinerariesByTrip(String tripId) {
        return repository.findAll(tripId);
    }

}
