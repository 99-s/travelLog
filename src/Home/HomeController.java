package Home;

import Itineraries.ItinerariesController;
import Trip.TripController;

public class HomeController {
    private HomeView homeView;
    private TripController tripController;
    private ItinerariesController itinerariesController;

    public HomeController(HomeView homeView, TripController tripController, ItinerariesController itinerariesController) {
        this.homeView = homeView;
        this.tripController = tripController;
        this.itinerariesController = itinerariesController;
    }


    public void start() {
        boolean running = true;
        while (running) {
            int menu = homeView.showMenuAndGetSelection();

            switch (menu) {
                case 1:
                    System.out.println("여행 기록 선택됨");
                    // TODO: TripController 호출
                    break;
                case 2:
                    System.out.println("여정 기록 선택됨");
                    // TODO: ItinerariesController 호출
                    itinerariesController.recordItineraries();
                    break;
                case 3:
                    System.out.println("여행 조회 선택됨");
                    // TODO: TripController 조회 기능 호출

                    break;
                case 4:
                    System.out.println("여정 조회 선택됨");
                    // TODO: ItinerariesController 조회 기능 호출
                    itinerariesController.showAllItineraries();

                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    running = false;
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
        }
    }
}
