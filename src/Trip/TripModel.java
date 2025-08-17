package Trip;

import Itineraries.Itinerary;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripModel {
    private String tripId;
    private String tripName;
    private String startDate;
    private String endDate;
    private List<Itinerary> itineraries;

    public TripModel(String tripName, String startDate, String endDate) {
        this.tripId = UUID.randomUUID().toString();;
        this.tripName = tripName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.itineraries = new ArrayList<>();
    }

    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    public String getTripId() { return tripId; }
    public String getTripName() { return tripName; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public List<Itinerary> getItineraries() { return itineraries; }

}
