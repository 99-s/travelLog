package Itineraries;
<<<<<<< HEAD
public class Itinerary {
=======

import AccommodationInfo.AccommodationInfo;
import MoveInfo.MoveInfo;

import java.util.List;
import java.util.UUID;

public class Itinerary {
    private String itineraryId;
    private String tripId;
    private MoveInfo moveInfo;
    private String type;
    private AccommodationInfo accommodationInfo;

    public String getItineraryId() {
        return itineraryId;
    }

    public String getTripId() {
        return tripId;
    }

    public MoveInfo getMoveInfo() {
        return moveInfo;
    }

    public String getType() {
        return type;
    }
    public void setMoveInfo(MoveInfo moveInfo) {
        this.moveInfo = moveInfo;
    }

    public AccommodationInfo getAccommodationInfo() {
        return accommodationInfo;
    }

    public void setAccommodationInfo(AccommodationInfo accommodationInfo) {
        this.accommodationInfo = accommodationInfo;
    }

    public Itinerary(String tripId,String type) {
        this.itineraryId = UUID.randomUUID().toString();
        this.tripId = tripId;
        this.type= type;
    }
>>>>>>> 40d5a1fe78a98e8f971a71de6781ec9b8932dddd
}
