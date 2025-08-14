package MoveInfo;
import utils.ItineraryInputValidator;

import java.util.Scanner;

public class MoveInfoView {
    private static final String EXIT_CMD = "/quit";
    ItineraryInputValidator itineraryInputValidator = new ItineraryInputValidator();

    public MoveItinerary inputMoveInfo(String tripId){
        Scanner scan = new Scanner(System.in);
        String departure_place="";
        String departure_time="";
        String arrival_time="";


        System.out.println("@@@ 이동 정보 기록 @@@");

        System.out.print("출발지 : ");
        departure_place = scan.nextLine();
        if (departure_place.equalsIgnoreCase(EXIT_CMD)) return null;

        System.out.print("도착지 : ");
        String destination = scan.nextLine();
        if(destination.equalsIgnoreCase(EXIT_CMD)) return null;

        while(true){
            try{
                System.out.println("출발 시간을 입력하세요");

                System.out.print("연도 : ");
                String year = scan.nextLine();
                if(year.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkYear(year);

                System.out.print("월 : ");
                String month = scan.nextLine();
                if(month.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMonth(month);

                System.out.print("일 : ");
                String day = scan.nextLine();
                if(day.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkDay(year, month, day);

                System.out.print("시 : ");
                String hour = scan.nextLine();
                itineraryInputValidator.checkHour(hour);

                System.out.print("분 : ");
                String minute = scan.nextLine();
                if(hour.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMinute(minute);

                departure_time = buildTime(year, month, day, hour, minute);
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }

        while(true) {
            try {
                System.out.println("도착 시간을 입력하세요");
                System.out.print("연도 : ");
                String year = scan.nextLine();
                if(year.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkYear(year);

                System.out.print("월 : ");
                String month = scan.nextLine();
                if(month.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMonth(month);

                System.out.print("일 : ");
                String day = scan.nextLine();
                if(day.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkDay(year, month, day);

                System.out.print("시 : ");
                String hour = scan.nextLine();
                if(hour.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkHour(hour);

                System.out.print("분 : ");
                String minute = scan.nextLine();
                if(minute.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMinute(minute);

                arrival_time = buildTime(year, month, day, hour, minute);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }

        return new MoveItinerary(tripId,departure_place, destination, departure_time, arrival_time);
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

