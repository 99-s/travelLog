package Trip;

import Itineraries.Itinerary;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    private List<TripModel> trips = new ArrayList<>();
    private int nextId = 1;

    public TripModel save(String title, String startDate, String endDate) {
        TripModel trip = new TripModel(nextId++, title, startDate, endDate);
        trips.add(trip);
        return trip;
    }

    public List<TripModel> findAll() {
        return new ArrayList<>(trips);
    }

    public TripModel findById(int tripId) {
        for (TripModel trip : trips) {
            if (trip.getTripId() == tripId) {
                return trip;
            }
        }
        return null;
    }

    public void saveTripAsJson(TripModel trip) {
        String folderPath = "data/itineraries";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = folderPath + "/itinerary_" + trip.getTripId() + ".json";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(tripToJson(trip));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String tripToJson(TripModel trip) {
        StringBuilder sb = new StringBuilder();
        sb.append("  {\n");
        sb.append("    \"trip_id\": ").append(trip.getTripId()).append(",\n");
        sb.append("    \"trip_name\": \"").append(trip.getTripName()).append("\",\n");
        sb.append("    \"start_date\": \"").append(trip.getStartDate()).append("\",\n");
        sb.append("    \"end_date\": \"").append(trip.getEndDate()).append("\",\n");
        sb.append("    \"itineraries\": [\n");
//        for (Itinerary itin : trip.getItineraries()) {
//            sb.append("      {\n");
//            sb.append("        \"id\": ").append(itin.getItineraryId()).append(",\n");
//            sb.append("        \"title\": \"").append(itin.getTitle()).append("\"\n");
//            sb.append("      },\n");
//        }
        if (!trip.getItineraries().isEmpty()) sb.setLength(sb.length() - 2); // 마지막 콤마 제거
        sb.append("\n    ]\n");
        sb.append("  }");
        return sb.toString();
    }

}
