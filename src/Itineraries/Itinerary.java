package Itineraries;

import java.util.UUID;

public class Itinerary {
    private String itineraryId;
    private String tripId;
    private String type;
    // 이동 정보
    private String departurePlace;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    // 숙박 정보
    private String checkInTime;
    private String checkOutTime;

    public String getItineraryId() {
        return itineraryId;
    }

    public String getTripId() {
        return tripId;
    }

    public String getType() {
        return type;
    }

    // setter
    public void setMoveInfo(String departurePlace, String destination, String departureTime, String arrivalTime) {
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public void setAccommodationInfo(String checkInTime, String checkOutTime) {
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }


    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCheckIn() {
        return checkInTime;
    }

    public String getCheckOut() {
        return checkOutTime;
    }



    public Itinerary(String tripId,String type) {
        this.itineraryId = UUID.randomUUID().toString();
        this.tripId = tripId;
        this.type= type;
    }
}
