import AccommodationInfo.AccommodationInfoController;
import AccommodationInfo.AccommodationInfoView;
import Home.HomeController;
import Home.HomeView;
import Itineraries.*;
import MoveInfo.MoveInfoController;
import MoveInfo.MoveInfoView;
import Trip.*;
import utils.DataLoader;

public class Main {
    public static void main(String[] args) {
        HomeView homeView = new HomeView();

        TripView tripView = new TripView();
        TripRepository tripRepository = new TripRepository();
        ItinerariesRepository itinerariesRepository = new ItinerariesRepository(tripRepository);
        for (TripModel trip : DataLoader.loadTripsFromFolder("data/itineraries")) {
            TripModel savedTrip = tripRepository.save(trip.getTripId(), trip.getTripName(), trip.getStartDate(), trip.getEndDate());
            for (Itinerary it : trip.getItineraries()) {
                savedTrip.addItinerary(it);
            }
        }

        TripService tripService = new TripService(tripRepository, itinerariesRepository);
        TripController tripController = new TripController(tripView, tripService);
        AccommodationInfoController accommodationInfoController = new AccommodationInfoController();
        MoveInfoController moveInfoController = new MoveInfoController();
        AccommodationInfoView accommodationInfoView = new AccommodationInfoView();
        MoveInfoView moveInfoView = new MoveInfoView();

        ItinerariesView itinerariesView = new ItinerariesView();
        ItinerariesController itinerariesController = new ItinerariesController(itinerariesView, accommodationInfoController, moveInfoController, accommodationInfoView, moveInfoView, itinerariesService, tripService);
        HomeController homeController = new HomeController(homeView, tripController, itinerariesController);

        homeController.start();
    }
}
