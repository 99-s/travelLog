package Trip;

import Itineraries.Itinerary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    private List<TripModel> trips = new ArrayList<>();

    public TripModel save(String tripId, String title, String startDate, String endDate) {
        TripModel trip = new TripModel(tripId, title, startDate, endDate);
        trips.add(trip);
        return trip;
    }

    public List<TripModel> findAll() {
        return new ArrayList<>(trips);
    }

    public TripModel findById(String tripId) {
        for (TripModel trip : trips) {
            if (trip.getTripId().equals(tripId)) {
                return trip;
            }
        }
        return null;
    }

    public boolean existsById(String id) {
        return trips.stream().anyMatch(trip -> trip.getTripId().equals(id));
    }

    public void saveTripAsJson(TripModel trip) {
        String folderPath = "data/itineraries";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = folderPath + "/itinerary_" + trip.getTripId() + ".json";
//        String fileName = folderPath + "/itinerary_857142c0-3909-46bc-b680-c0476aef658e.json";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(tripToJson(trip));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String tripToJson(TripModel trip) {
        StringBuilder sb = new StringBuilder();
        sb.append("  {\n");
        sb.append("    \"trip_id\": \"").append(trip.getTripId()).append("\",\n");
        sb.append("    \"trip_name\": \"").append(trip.getTripName()).append("\",\n");
        sb.append("    \"start_date\": \"").append(trip.getStartDate()).append("\",\n");
        sb.append("    \"end_date\": \"").append(trip.getEndDate()).append("\",\n");
        sb.append("    \"itineraries\": [\n");
        for (Itinerary it : trip.getItineraries()) {
            sb.append("      {\n");
            sb.append("        \"itinerary_id\": \"").append(it.getItineraryId()).append(",\",\n");

            if (it.getDeparturePlace() != null)
                sb.append("        \"departure_place\": \"").append(it.getDeparturePlace()).append("\",\n");

            if (it.getDestination() != null)
                sb.append("        \"destination\": \"").append(it.getDestination()).append("\",\n");

            if (it.getDepartureTime() != null)
                sb.append("        \"departure_time\": \"").append(it.getDepartureTime()).append("\",\n");

            if (it.getArrivalTime() != null)
                sb.append("        \"arrival_time\": \"").append(it.getArrivalTime()).append("\",\n");

            if (it.getAccommodation() != null)
                sb.append("        \"accommodation\": \"").append(it.getAccommodation()).append("\",\n");

            if (it.getCheckIn() != null)
                sb.append("        \"check_in\": \"").append(it.getCheckIn()).append("\",\n");

            if (it.getCheckOut() != null)
                sb.append("        \"check_out\": \"").append(it.getCheckOut()).append("\"\n");

            sb.append("      },\n");
        }

        if (!trip.getItineraries().isEmpty()) sb.setLength(sb.length() - 2); // 마지막 콤마 제거
        sb.append("\n    ]\n");
        sb.append("  }");
        return sb.toString();
    }

}
