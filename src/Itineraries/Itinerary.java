package Itineraries;

import java.util.UUID;

public class Itinerary {
    private String itineraryId;
    private String tripId;
    private String type;

    public String getItineraryId() {
        return itineraryId;
    }

    public String getTripId() {
        return tripId;
    }

    public String getType() {
        return type;
    }

    public Itinerary(String tripId,String type) {
        this.itineraryId = UUID.randomUUID().toString();
        this.tripId = tripId;
        this.type= type;
    }
}
