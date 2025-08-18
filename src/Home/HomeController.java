package Home;

import Itineraries.ItinerariesController;
import Trip.TripController;
import utils.InvalidMenuSelectionException;

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
            try {
                int menu = homeView.showMenuAndGetSelection();

                switch (menu) {
                    case 1 -> tripController.createTrip();
                    case 2 -> itinerariesController.recordItineraries();
                    case 3 -> tripController.showTripsAndDetails();
                    case 4 -> itinerariesController.showAllItineraries();
                    case 5 -> {
                        System.out.println("프로그램 종료");
                        running = false;
                    }
                    default -> System.out.println("올바른 메뉴 번호를 입력하세요.");
                }
            } catch (InvalidMenuSelectionException e) {
                System.out.println("[입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[시스템 오류] " + e.getMessage());
            }
        }
    }
}
