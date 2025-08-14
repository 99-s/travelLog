import Home.HomeController;
import Home.HomeView;
import Itineraries.ItinerariesController;
import Itineraries.ItinerariesRepository;
import Itineraries.ItinerariesService;
import Itineraries.ItinerariesView;
import Trip.TripController;
import Trip.TripRepository;
import Trip.TripService;
import Trip.TripView;

public class Main {
    public static void main(String[] args) {
        HomeView homeView = new HomeView();

        TripView tripView = new TripView();
        TripRepository tripRepository = new TripRepository();
        TripService tripService = new TripService(tripRepository);
        TripController tripController = new TripController(tripView, tripService);

        ItinerariesView itinerariesView = new ItinerariesView();
        ItinerariesRepository itinerariesRepository = new ItinerariesRepository();
        ItinerariesService itinerariesService = new ItinerariesService(itinerariesRepository);
//        ItinerariesController itinerariesController = new ItinerariesController(itinerariesView, itinerariesService);

//        HomeController homeController = new HomeController(homeView, tripController, itinerariesController);
//
//        homeController.start();
    }
}
