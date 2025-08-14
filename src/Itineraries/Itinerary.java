package Itineraries;
<<<<<<< HEAD
public class Itinerary {
=======

import AccommodationInfo.AccommodationInfo;
import MoveInfo.MoveInfo;

import java.util.List;

public class Itinerary {
    private static int idCounter = 1;
    private String itineraryId;
    private String type;
    private String tripId;

    public String getTripId() {
        return tripId;
    }

    public String getItineraryId() {
        return itineraryId;

    }

    public Itinerary(String type, String tripId) {
        this.itineraryId = "ITN-" + (idCounter++) ;
        this.type = type;
        this.tripId = tripId;
    }
>>>>>>> 40d5a1fe78a98e8f971a71de6781ec9b8932dddd
}
