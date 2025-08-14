package MoveInfo;

import Itineraries.Itinerary;

public class MoveItinerary extends Itinerary {
    private String departure_place;
    private String destination;
    private String departure_time;
    private String arrival_time;

    public MoveItinerary(String tripId, String departure_place, String destination,
                         String departure_time, String arrival_time) {
        super("M", tripId); // 부모 생성자 호출 → type=M, tripId 설정, id 자동 생성
        this.departure_place = departure_place;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }

    // Getter (조회 시 View에서 출력하기 위해)
    public String getDeparture_place() {
        return departure_place;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }
}
