package Itineraries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItinerariesRepository {
    private Map<String, List<Itinerary>> db = new HashMap<>();

    // 여정 1개 저장
    public void save(Itinerary itinerary) {
        String tripId = itinerary.getTripId();

        // 해당 tripId에 리스트가 없으면 새로 만들고, 있다면 그 리스트에 add
        db.computeIfAbsent(tripId, k -> new ArrayList<>()).add(itinerary);
    }
    public List<Itinerary> findAll(String tripId){
        return db.getOrDefault(tripId, new ArrayList<>());
    }
}
