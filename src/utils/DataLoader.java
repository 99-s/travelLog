package utils;

import AccommodationInfo.AccommodationItinerary;
import MoveInfo.MoveItinerary;
import Trip.TripModel;
import Itineraries.Itinerary;
import java.io.*;
import java.util.*;

public class DataLoader {

    public static List<TripModel> loadTripsFromFolder(String folderPath) {
        List<TripModel> trips = new ArrayList<>();

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) return trips;

        File[] files = folder.listFiles((dir, name) -> name.startsWith("itinerary_") && name.endsWith(".json"));
        if (files == null) return trips;

        for (File file : files) {
            TripModel trip = readTripFromJson(file);
            if (trip != null) {
                trips.add(trip);
            }
        }
        return trips;
    }

    private static TripModel readTripFromJson(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }

            String json = sb.toString();

            String tripId = extractValue(json, "trip_id");
            String tripName = extractValue(json, "trip_name");
            String startDate = extractValue(json, "start_date");
            String endDate = extractValue(json, "end_date");

            TripModel trip = new TripModel(tripName, startDate, endDate);

            // itineraries 배열 파싱
            String itinerariesJson = extractArray(json, "itineraries");
            List<Itinerary> itineraries = parseItineraries(itinerariesJson, tripId);

            for (Itinerary it : itineraries) {
                trip.addItinerary(it);
            }

            return trip;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String extractValue(String json, String key) {
        String pattern = "\"" + key + "\":";
        int start = json.indexOf(pattern);
        if (start == -1) return null;

        start += pattern.length();
        int firstQuote = json.indexOf("\"", start);
        int secondQuote = json.indexOf("\"", firstQuote + 1);

        if (firstQuote == -1 || secondQuote == -1) return null;

        return json.substring(firstQuote + 1, secondQuote);
    }

    private static String extractArray(String json, String key) {
        String pattern = "\"" + key + "\":[";
        int start = json.indexOf(pattern);
        if (start == -1) return null;

        start += pattern.length();
        int end = json.indexOf("]", start);
        return json.substring(start, end + 1);
    }

    private static Itinerary parseItinerary(String json, String tripId) {
        String type = extractValue(json, "type");

        if ("move".equals(type)) {
            String departurePlace = extractValue(json, "departure_place");
            String destination = extractValue(json, "destination");
            String departureTime = extractValue(json, "departure_time");
            String arrivalTime = extractValue(json, "arrival_time");

            return new MoveItinerary(tripId, departurePlace, destination, departureTime, arrivalTime);
        }
        else if ("accommodation".equals(type)) {
            String accommodation = extractValue(json, "accommodation");
            String checkIn = extractValue(json, "check_in");
            String checkOut = extractValue(json, "check_out");

            return new AccommodationItinerary(tripId, accommodation, checkIn, checkOut);
        }
        else {
            // 기본 Itinerary (예: type만 있는 경우)
            return new Itinerary(tripId, type);
        }
    }
    private static List<Itinerary> parseItineraries(String itinerariesJson, String tripId) {
        List<Itinerary> itineraries = new ArrayList<>();

        if (itinerariesJson == null || itinerariesJson.isEmpty()) return itineraries;

        String[] items = itinerariesJson.split("\\},\\{");

        for (String item : items) {
            Itinerary it = parseItinerary(item, tripId);
            if (it != null) itineraries.add(it);
        }

        return itineraries;
    }
}
