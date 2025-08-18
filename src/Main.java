import AccommodationInfo.AccommodationController;
import Home.HomeController;
import Home.HomeView;
import Itineraries.*;
import MoveInfo.MoveInfoController;
import Trip.*;
import utils.DataLoader;

public class Main {
    public static void main(String[] args) {
        HomeView homeView = new HomeView();

        TripView tripView = new TripView();
        TripRepository tripRepository = new TripRepository();

        for (TripModel trip : DataLoader.loadTripsFromFolder("data/itineraries")) {
            TripModel savedTrip = tripRepository.save(trip.getTripId(), trip.getTripName(), trip.getStartDate(), trip.getEndDate());
            for (Itinerary it : trip.getItineraries()) {
                savedTrip.addItinerary(it);
            }
        }

        TripService tripService = new TripService(tripRepository);
        TripController tripController = new TripController(tripView, tripService);
        AccommodationController accommodationController = new AccommodationController();
        MoveInfoController moveInfoController = new MoveInfoController();

        ItinerariesView itinerariesView = new ItinerariesView();
        ItinerariesRepository itinerariesRepository = new ItinerariesRepository();
        ItinerariesService itinerariesService = new ItinerariesService(itinerariesRepository);
        ItinerariesController itinerariesController = new ItinerariesController(itinerariesView,accommodationController,moveInfoController,itinerariesService);
        HomeController homeController = new HomeController(homeView, tripController, itinerariesController);

        homeController.start();
    }
}
