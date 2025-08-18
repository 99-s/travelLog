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
    private String accommodation;
    private String checkInTime;
    private String checkOutTime;
  
    public void setType(String type) {
        this.type = type;
    }

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

    public void setAccommodation(String accommodation){
        this.accommodation = accommodation;
    }
    
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

    public String getAccommodation(){
        return accommodation;
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

    public String getType() {
        return type;
    }

    public Itinerary(String tripId, String type) {
        this.itineraryId = UUID.randomUUID().toString();
        this.tripId = tripId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "itineraryId='" + itineraryId + '\'' +
                ", tripId='" + tripId + '\'' +
                ", type='" + type + '\'' +
                ", departurePlace='" + departurePlace + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                '}';
    }
}
