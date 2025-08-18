package Trip;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class TripView {
    private Scanner sc = new Scanner(System.in);

    public TripModel inputTripInfo() {
        System.out.println("@@@ 여행기록 @@@");

        System.out.print("여행명 : ");
        String title = sc.nextLine();
        while (title.isBlank()) {
            System.out.print("[오류] 여행명은 비워둘 수 없습니다. 다시 입력하세요: ");
            title = sc.nextLine();
        }

        String startDate = inputDate("시작");
        String endDate = inputDate("종료");

        if (!isEndDateAfterStartDate(startDate, endDate)) {
            System.out.println("[오류] 여행 종료일은 시작일 이후여야 합니다.");
            return inputTripInfo(); // 재귀 호출해서 다시 입력 받음
        }

        return new TripModel(title, startDate, endDate);
    }

    private boolean isEndDateAfterStartDate(String startDate, String endDate) {
        java.time.LocalDate start = java.time.LocalDate.parse(startDate);
        java.time.LocalDate end = java.time.LocalDate.parse(endDate);
        return !end.isBefore(start);
    }

    private String inputDate(String label) {
        System.out.println(label + " 날짜를 입력하세요");

        int year = inputNumber("년도");
        int month = inputNumber("월", 1, 12);
        int day = inputNumber("일", 1, 31);

        if (year < 1000 || year > 9999) {
            throw new IllegalArgumentException("[시스템 오류] 년도는 4자리로 입력해야 합니다.");
        }

        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    private int inputNumber(String label) {
        while (true) {
            try {
                System.out.print(label + " : ");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("[오류] 숫자를 입력하세요.");
            }
        }
    }

    private int inputNumber(String label, int min, int max) {
        while (true) {
            int num = inputNumber(label);
            if (num < min || num > max) {
                System.out.println("[오류] " + label + "는 " + min + " ~ " + max + " 범위여야 합니다.");
            } else {
                return num;
            }
        }
    }

    public String inputTripId() {
        System.out.print("상세 조회할 여행 ID를 입력하세요: ");
        return sc.next();
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
            // itineraries 출력은 나중에 Itinerary 구현 후 추가
        }
    }
}