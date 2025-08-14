package AccommodationInfo;

public class AccommodationInfoController {

    public AccommodationItinerary accommodationInfoControllerRun(String tripId){
        AccommodationInfoView moveInfoView = new AccommodationInfoView();
        return moveInfoView.inputAccommodationInfo(tripId);
    }


}
