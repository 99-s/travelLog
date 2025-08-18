package Itineraries;

import java.util.UUID;

public class Itinerary {
    private String itineraryId;
    private String tripId;

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCheckIn(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOut(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

>>>>>>> 8ca7984 (itineraries)
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

    public Itinerary(String tripId, String type) {
        this.itineraryId = UUID.randomUUID().toString();
        this.tripId = tripId;
        this.type = type;
    }
}
