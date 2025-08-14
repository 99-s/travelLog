package Trip;

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
}
