package AccommodationInfo;

import Itineraries.Itinerary;

import java.util.Scanner;

public class AccommodationInfoView {
    public AccommodationItinerary inputAccommodationInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("도착지를 입력하세요(숙소명) : ");
        String accommodation = scan.nextLine();
        System.out.println("체크인 시간을 입력하세요 : ");
        String check_in = scan.nextLine();
        System.out.println("체크아웃 시간을 입력하세요 : ");
        String check_out = scan.nextLine();

        return new AccommodationItinerary(accommodation, check_in, check_out);
    }
    public void printAccommodationInfo(AccommodationItinerary info) {
        System.out.println("숙소명 : " + info.getAccommodation());
        System.out.println("체크인 : " + info.getCheckIn());
        System.out.println("체크아웃 : " + info.getCheckOut());
    }
}
//private String accommodation;
//private String check_in;
//private String check_out;