package Itineraries;

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
}
