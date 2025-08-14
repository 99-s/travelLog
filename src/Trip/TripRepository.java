package Trip;

import Itineraries.Itinerary;
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

    private String toJson() {
        StringBuilder sb = new StringBuilder("[\n");
        for (TripModel trip : trips) {
            sb.append(tripToJson(trip)).append(",\n");
        }
        if (!trips.isEmpty()) sb.setLength(sb.length() - 2); // 마지막 콤마 제거
        sb.append("\n]");
        return sb.toString();
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

    public void saveJsonToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
