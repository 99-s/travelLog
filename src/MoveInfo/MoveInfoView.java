package MoveInfo;
import utils.ItineraryInputValidator;

import java.util.Scanner;

public class MoveInfoView {
    ItineraryInputValidator itineraryInputValidator = new ItineraryInputValidator();

    public MoveItinerary inputMoveInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("@@@ 이동 정보 기록 @@@");

        System.out.print("출발지 : ");
        String departure_place = sc.nextLine();
        System.out.print("도착지 : ");
        String destination = sc.nextLine();

        System.out.println("출발 시간");
        System.out.print("년도 : ");
        String year = sc.nextLine();
        itineraryInputValidator.checkYear(year);
        System.out.print("월 : ");
        String month = sc.nextLine();
        itineraryInputValidator.checkMonth(month);
        System.out.print("일 : ");
        String day = sc.nextLine();
        itineraryInputValidator.checkDay(year, month, day);
        System.out.print("시 : ");
        String hour = sc.nextLine();
        itineraryInputValidator.checkHour(hour);
        System.out.print("분 : ");
        String minute = sc.nextLine();
        itineraryInputValidator.checkMinute(minute);

        String departure_time = buildTime(year, month, day, hour, minute);

        System.out.println("도착 시간");
        System.out.print("년도 : ");
        year = sc.nextLine();
        itineraryInputValidator.checkYear(year);
        System.out.print("월 : ");
        month = sc.nextLine();
        itineraryInputValidator.checkMonth(month);
        System.out.print("일 : ");
        day = sc.nextLine();
        itineraryInputValidator.checkDay(year, month, day);
        System.out.print("시 : ");
        hour = sc.nextLine();
        itineraryInputValidator.checkHour(hour);
        System.out.print("분 : ");
        minute = sc.nextLine();
        itineraryInputValidator.checkMinute(minute);

        String arrival_time = buildTime(year, month, day, hour, minute);

        return new MoveItinerary(departure_place, destination, departure_time, arrival_time);
    }

    public String buildTime(String year, String month, String day, String hour, String minute) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        int h = Integer.parseInt(hour);
        int min = Integer.parseInt(minute);

        return String.format("%04d-%02d-%02d %02d:%02d", y, m, d, h, min);
    }

}

