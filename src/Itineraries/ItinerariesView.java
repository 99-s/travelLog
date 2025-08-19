package Itineraries;

import java.util.List;
import java.util.Scanner;

public class ItinerariesView {
    private final Scanner sc = new Scanner(System.in);

    public void printWelcomeMessage() {
        System.out.println("@@@ 여정 기록 시스템 @@@");
    }

    public String askTripId() {
        System.out.print("여행 ID를 입력하세요: ");
        return sc.nextLine();
    }

    public boolean askYesNo(String prompt) {
        System.out.print(prompt + " (Y/N): ");
        String input = sc.nextLine().trim().toUpperCase();
        return input.equals("Y");
    }

    public String askItineraryType() {
        System.out.print("입력할 여정의 종류를 선택하세요 (숙박: A / 이동: M): ");
        return sc.nextLine().trim().toUpperCase();
    }

    public void showInvalidType() {
        System.out.println("잘못된 여정 타입입니다. A 또는 M을 입력해주세요.");
    }

    public void printItineraries(String tripId, List<Itinerary> itineraries) {
        System.out.println("@@@ " + tripId + "의 전체 여정 목록 @@@");

        for (Itinerary it : itineraries) {
            System.out.println("=== 여정 정보 ===");
            System.out.println("ID: " + it.getItineraryId());
            if (it.getDeparturePlace() != null)
                System.out.println("출발지: " + it.getDeparturePlace());
            if (it.getDestination() != null)
                System.out.println("목적지: " + it.getDestination());
            if (it.getDepartureTime() != null)
                System.out.println("출발 시간: " + it.getDepartureTime());
            if (it.getArrivalTime() != null)
                System.out.println("도착 시간: " + it.getArrivalTime());
            if (it.getAccommodation() != null)
                System.out.println("숙소: " + it.getAccommodation());
            if (it.getCheckIn() != null)
                System.out.println("체크인: " + it.getCheckIn());
            if (it.getCheckOut() != null)
                System.out.println("체크아웃: " + it.getCheckOut());
            System.out.println();
        }

    }

}
