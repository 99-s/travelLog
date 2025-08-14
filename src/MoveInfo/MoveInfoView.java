package MoveInfo;
import java.util.Scanner;

public class MoveInfoView {

    public MoveItinerary inputMoveInfo(String tripId){
        Scanner sc = new Scanner(System.in);
        System.out.println("@@@ 이동 정보 기록 @@@");
        System.out.print("출발지 : ");
        String departure_place = sc.nextLine();
        System.out.println("도착지 : ");
        String destination = sc.nextLine();
        System.out.print("출발시간 : ");
        String departure_time = sc.nextLine();
        System.out.print("도착 시간 : ");
        String arrival_time = sc.nextLine();

        return new MoveItinerary(tripId,departure_place, destination, departure_time, arrival_time);
    }


}

