package Itineraries;

import AccommodationInfo.AccommodationInfo;
import MoveInfo.MoveInfo;

import java.util.List;

public class Itinerary {
    private static int idCounter = 1;
    private String itineraryId;
    private String type;

    public String getTripId() {
        return tripId;
    }

    private String tripId;

    public String getItineraryId() {
        return itineraryId;

    }

    public Itinerary(String type, String tripId) {
        this.itineraryId = "ITN-" + (idCounter++) ;
        this.type = type;
        this.tripId = tripId;
    }
}
