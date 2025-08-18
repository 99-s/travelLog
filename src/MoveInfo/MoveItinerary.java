package MoveInfo;

import Itineraries.Itinerary;

public class MoveItinerary extends Itinerary {
    private String departurePlace;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    public MoveItinerary(String tripId, String departurePlace, String destination,
                         String departureTime, String arrivalTime) {
        super("M", tripId); // 부모 생성자 호출 → type=M, tripId 설정, id 자동 생성
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public MoveItinerary(String itineraryId, String tripId, String departurePlace, String destination,
                         String departureTime, String arrivalTime) {
        super(itineraryId, tripId, "move");
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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
}
