
import AccommodationInfo.AccommodationInfoController;
import AccommodationInfo.AccommodationInfoView;
import Home.HomeController;
import Home.HomeView;
import Itineraries.ItinerariesController;
import Itineraries.ItinerariesRepository;
import Itineraries.ItinerariesService;
import Itineraries.ItinerariesView;
import MoveInfo.MoveInfoController;
import MoveInfo.MoveInfoView;
import Trip.TripController;
import Trip.TripRepository;
import Trip.TripService;
import Trip.TripView;

public class Main {
    public static void main(String[] args) {
        HomeView homeView = new HomeView();

        TripView tripView = new TripView();
        TripRepository tripRepository = new TripRepository();
        ItinerariesRepository itinerariesRepository = new ItinerariesRepository(tripRepository);

        TripService tripService = new TripService(tripRepository, itinerariesRepository);
        TripController tripController = new TripController(tripView, tripService);
        AccommodationInfoController accommodationInfoController = new AccommodationInfoController();
        MoveInfoController moveInfoController = new MoveInfoController();
        AccommodationInfoView accommodationInfoView = new AccommodationInfoView();
        MoveInfoView moveInfoView = new MoveInfoView();

        ItinerariesView itinerariesView = new ItinerariesView();
        ItinerariesService itinerariesService = new ItinerariesService(itinerariesRepository);
        ItinerariesController itinerariesController = new ItinerariesController(itinerariesView,accommodationInfoController,moveInfoController,accommodationInfoView,moveInfoView,itinerariesService);
        HomeController homeController = new HomeController(homeView, tripController, itinerariesController);

        homeController.start();
    }
}
