package Trip;

import utils.DateValidator;
import utils.StringValidator;
import utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class TripView {
    private Scanner sc = new Scanner(System.in);

    public TripModel inputTripInfo() {
        System.out.println("@@@ 여행기록 @@@");

        String title = inputTripTitle();
        String startDate = inputDate("시작");
        String endDate = inputDate("종료");

        // 날짜 범위 검증 (strict=true로 설정하여 시작일 < 종료일 검증)
        try {
            DateValidator.validateDateRange(startDate, endDate, true);
            System.out.println("여행 기간: " + startDate + " ~ " + endDate);
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
            return inputTripInfo();
        }

        return new TripModel(title, startDate, endDate);
    }

    private String inputTripTitle() {
        while (true) {
            try {
                System.out.print("여행명 : ");
                String title = sc.nextLine();
                StringValidator.validateNotEmpty(title, "여행명");
                StringValidator.validateMaxLength(title, "여행명", 100);
                return title;
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private String inputDate(String label) {
        System.out.println(label + " 날짜를 입력하세요");

        int year = inputYear();
        int month = inputMonth();
        int day = inputDay(year, month);

        return String.format("%04d-%02d-%02d", year, month, day);
    }

    private int inputYear() {
        while (true) {
            try {
                System.out.print("년도 : ");
                String yearStr = sc.nextLine();
                DateValidator.validateYear(yearStr);
                return Integer.parseInt(yearStr);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private int inputMonth() {
        while (true) {
            try {
                System.out.print("월 : ");
                String monthStr = sc.nextLine();
                DateValidator.validateMonth(monthStr);
                return Integer.parseInt(monthStr);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private int inputDay(int year, int month) {
        while (true) {
            try {
                System.out.print("일 : ");
                String dayStr = sc.nextLine();
                DateValidator.validateDay(String.valueOf(year), String.valueOf(month), dayStr);
                return Integer.parseInt(dayStr);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    public String inputTripId() {
        while (true) {
            try {
                System.out.print("상세 조회할 여행 ID를 입력하세요: ");
                String tripId = sc.nextLine();
                StringValidator.validateNotEmpty(tripId, "여행 ID");
                return tripId;
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
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
    }
}