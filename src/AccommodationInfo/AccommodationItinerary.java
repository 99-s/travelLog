package AccommodationInfo;
import Itineraries.Itinerary;

public class AccommodationItinerary extends Itinerary {
    private String accommodation;
    private String check_in;
    private String check_out;
    public AccommodationItinerary(String tripId, String accommodation, String check_in, String check_out) {
        super(tripId, "accommodation");
        this.accommodation = accommodation;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public String getCheckIn() {
        return check_in;
    }
    public String getCheckOut() {
        return check_out;
    }
    public String getAccommodation() {
        return accommodation;
    }

}
