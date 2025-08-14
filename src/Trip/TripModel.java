package Trip;

import Itineraries.Itinerary;
import java.util.ArrayList;
import java.util.List;

public class TripModel {
    private int tripId;
    private String tripName;
    private String startDate;
    private String endDate;
    private List<Itinerary> itineraries;

    public TripModel(int tripId, String tripName, String startDate, String endDate) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.itineraries = new ArrayList<>();
    }

    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }
}
