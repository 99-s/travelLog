package AccommodationInfo;

import java.util.Scanner;

public class AccommodationInfoView {
    public AccommodationItinerary inputAccommodationInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("도착지를 입력하세요(숙소명) : ");
        String accommodation = scan.nextLine();
        System.out.println("체크인 시간을 입력하세요");
        System.out.println("연도 : ");
        String year = scan.nextLine();
        System.out.println("월 : ");
        String month = scan.nextLine();
        System.out.println("일 : ");
        String day= scan.nextLine();
        System.out.println("시 : ");
        String hour = scan.nextLine();
        System.out.println("분 : ");
        String minute = scan.nextLine();
        String check_in = year+"-"+month+"-"+day+"T"+hour+":"+minute+":00";

        System.out.println("체크아웃 시간을 입력하세요");
        System.out.println("연도 : ");
        year = scan.nextLine();
        System.out.println("월 : ");
        month = scan.nextLine();
        System.out.println("일 : ");
        day= scan.nextLine();
        System.out.println("시 : ");
        hour = scan.nextLine();
        System.out.println("분 : ");
        minute = scan.nextLine();
        //예외처리
        String check_out = year+"-"+month+"-"+day+"T"+hour+":"+minute+":00";
        return new AccommodationItinerary(accommodation, check_in, check_out);
    }
}