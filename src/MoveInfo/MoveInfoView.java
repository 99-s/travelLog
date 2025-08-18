package MoveInfo;

import Itineraries.Itinerary;
import utils.ItineraryInputHelper;
import utils.DateValidator;

public class MoveInfoView {
    private final ItineraryInputHelper helper = new ItineraryInputHelper();

    public Itinerary inputMoveInfo(String tripId) {
        System.out.println("@@@ 이동 정보 기록 @@@");

        // 출발지
        String departurePlace = helper.inputNonEmptyText("출발지");
        if (departurePlace == null) return null;

        // 도착지
        String destination = helper.inputNonEmptyText("도착지");
        if (destination == null) return null;

        // 출발/도착 시간
        String departureTime = helper.inputDateTime("출발");
        if (departureTime == null) return null;

        String arrivalTime = helper.inputDateTime("도착");
        if (arrivalTime == null) return null;

        // 출발 < 도착 검증
        try {
            DateValidator.validateTimeRange(departureTime, arrivalTime, true);
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
            System.out.println("출발/도착 시간을 다시 입력해주세요.");
            return inputMoveInfo(tripId); // 재시도
        }

        System.out.println("입력된 이동 정보:");
        System.out.println("출발지: " + departurePlace);
        System.out.println("도착지: " + destination);
        System.out.println("출발시간: " + departureTime);
        System.out.println("도착시간: " + arrivalTime);

        Itinerary itinerary = new Itinerary(tripId, "M");
        itinerary.setMoveInfo(departurePlace, destination, departureTime, arrivalTime);
        return itinerary;
    }
}
