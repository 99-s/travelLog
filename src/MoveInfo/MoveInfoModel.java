package MoveInfo;

public class MoveInfoModel {
    private int id;
    private String departure_place;
    private String destination;
    private String departure_time;
    private String arrival_time;

    MoveInfoModel(String departure_place,String destination, String departure_time, String arrival_time){
        this.departure_place=departure_place;
        this.destination=destination;
        this.departure_time =departure_time;
        this.arrival_time = arrival_time;

    }
}
