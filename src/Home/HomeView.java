package Home;

import java.util.Scanner;

public class HomeView {
    private Scanner sc = new Scanner(System.in);

    public int showMenuAndGetSelection() {
        System.out.println("@@@ 시작화면 @@@");
        System.out.println("메뉴리스트 : 여행 기록(1), 여정 기록(2), 여행 조회(3), 여정 조회(4), 종료(5)");
        System.out.print("시작할 메뉴번호를 입력 하세요 : ");

        int menu = sc.nextInt();
        sc.nextLine();
        return menu;
    }
}
