package Trip;

import java.util.List;
import java.util.Scanner;

public class TripView {

    public TripModel inputTripInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("@@@ 여행기록 @@@");
        System.out.print("여행명 : ");
        String title = sc.nextLine();

        System.out.println("시작 날짜를 입력하세요");
        System.out.print("년도 : ");
        String startYear = sc.nextLine();
        System.out.print("월 : ");
        String startMonth = sc.nextLine();
        System.out.print("일 : ");
        String startDay = sc.nextLine();
        String startDate = startYear + "-" + startMonth + "-" + startDay;

        System.out.println("종료 날짜를 입력하세요");
        System.out.print("년도 : ");
        String endYear = sc.nextLine();
        System.out.print("월 : ");
        String endMonth = sc.nextLine();
        System.out.print("일 : ");
        String endDay = sc.nextLine();
        String endDate = endYear + "-" + endMonth + "-" + endDay;

        return new TripModel(0, title, startDate, endDate);
    }

    public int inputTripId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상세 조회할 여행 ID를 입력하세요: ");
        return sc.nextInt();
    }

    public void printTripList(List<TripModel> trips) {
        System.out.println("@@@ 여행 전체 리스트 @@@");
        if (trips.isEmpty()) {
            System.out.println("등록된 여행이 없습니다.");
        } else {
            for (TripModel trip : trips) {
                System.out.println(trip.getTripId() + ". " + trip.getTripName() +
                        " (" + trip.getStartDate() + " ~ " + trip.getEndDate() + ")");
            }
        }
    }

    public void printTripDetails(TripModel trip) {
        System.out.println("@@@ 여행 상세 정보 @@@");
        System.out.println("ID: " + trip.getTripId());
        System.out.println("여행명: " + trip.getTripName());
        System.out.println("기간: " + trip.getStartDate() + " ~ " + trip.getEndDate());

        System.out.println("여정 리스트:");
        if (trip.getItineraries().isEmpty()) {
            System.out.println("  등록된 여정이 없습니다.");
        } else {
//            for (Itinerary it : trip.getItineraries()) {
//                System.out.println("  - " + it.getDate() + ": " + it.getTitle());
//            }
        }
    }

}
