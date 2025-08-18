package AccommodationInfo;

import Itineraries.Itinerary;

public class AccommodationInfoController {

    public Itinerary accommodationInfoControllerRun(String tripId) {
        AccommodationInfoView accommodationInfoView = new AccommodationInfoView();
        return accommodationInfoView.inputAccommodationInfo(tripId);
    }
}
