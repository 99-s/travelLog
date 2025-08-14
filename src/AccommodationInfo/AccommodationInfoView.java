package AccommodationInfo;

import utils.ItineraryInputValidator;

import java.util.Scanner;

public class AccommodationInfoView {
    private static final String EXIT_CMD = "/quit";
    ItineraryInputValidator itineraryInputValidator = new ItineraryInputValidator();

    public AccommodationItinerary inputAccommodationInfo() {
        Scanner scan = new Scanner(System.in);
        String accommodation="";
        String check_in="";
        String check_out="";

        System.out.println("@@@ 숙소 정보 기록 @@@");

        System.out.print("숙소명 : ");
        accommodation = scan.nextLine();
        if (accommodation.equalsIgnoreCase(EXIT_CMD)) return null;

        while(true) {
            try {
                System.out.println("체크인 시간을 입력하세요");
                System.out.println("연도 : ");
                String year = scan.nextLine();
                if (year.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkYear(year);

                System.out.println("월 : ");
                String month = scan.nextLine();
                if (month.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMonth(month);

                System.out.println("일 : ");
                String day = scan.nextLine();
                if (day.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkDay(year, month, day);

                System.out.println("시 : ");
                String hour = scan.nextLine();
                if (hour.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkHour(hour);

                System.out.println("분 : ");
                String minute = scan.nextLine();
                if (minute.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMinute(minute);

                check_in =buildTime(year, month, day, hour, minute);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
        while(true) {
            try {
                System.out.println("체크아웃 시간을 입력하세요");

                System.out.println("연도 : ");
                String year = scan.nextLine();
                if(year.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkYear(year);

                System.out.println("월 : ");
                String month = scan.nextLine();
                if(month.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMonth(month);

                System.out.println("일 : ");
                String day= scan.nextLine();
                if(day.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkDay(year, month, day);

                System.out.println("시 : ");
                String hour = scan.nextLine();
                if(hour.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkHour(hour);

                System.out.println("분 : ");
                String minute = scan.nextLine();
                if(minute.equalsIgnoreCase(EXIT_CMD)) return null;
                itineraryInputValidator.checkMinute(minute);

                check_out =buildTime(year, month, day, hour, minute);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }

        return new AccommodationItinerary(accommodation, check_in, check_out);
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