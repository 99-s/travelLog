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
        
        if (itineraries.isEmpty()) {
            System.out.println("등록된 여정이 없습니다.");
            return;
        }

        for (int i = 0; i < itineraries.size(); i++) {
            Itinerary it = itineraries.get(i);
            System.out.println("\n[" + (i + 1) + "] 여정 ID: " + it.getItineraryId());
            System.out.println("    타입: " + getTypeDescription(it.getType()));
            
            if (it.getType().equals("A")) {
                // 숙박 여정
                System.out.println("    숙소명: " + it.getAccommodation());
                System.out.println("    체크인: " + it.getCheckIn());
                System.out.println("    체크아웃: " + it.getCheckOut());
            } else if (it.getType().equals("M")) {
                // 이동 여정
                System.out.println("    출발지: " + it.getDeparturePlace());
                System.out.println("    도착지: " + it.getDestination());
                System.out.println("    출발시간: " + it.getDepartureTime());
                System.out.println("    도착시간: " + it.getArrivalTime());
            }
            
            if (i < itineraries.size() - 1) {
                System.out.println("    ──────────────────────");
            }
        }
        
        System.out.println("\n총 " + itineraries.size() + "개의 여정이 등록되어 있습니다.");
    }
    
    private String getTypeDescription(String type) {
        return type.equals("A") ? "숙박" : type.equals("M") ? "이동" : "알 수 없음";
    }
}
