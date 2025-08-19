package AccommodationInfo;

import Itineraries.Itinerary;
import utils.ItineraryInputHelper;
import utils.DateValidator;

public class AccommodationInfoView {
    private final ItineraryInputHelper helper = new ItineraryInputHelper();

    // 반환 타입을 Itinerary로 변경
    public Itinerary inputAccommodationInfo(String tripId) {
        System.out.println("@@@ 숙소 정보 기록 @@@");
        System.out.println("※ 체크인 시간은 체크아웃 시간보다 이전이어야 합니다.");

        // 숙소명 입력
        String accommodation = helper.inputNonEmptyText("숙소명");
        if (accommodation == null) return null;

        // 체크인 입력
        String checkIn = helper.inputDateTime("체크인");
        if (checkIn == null) return null;

        // 체크아웃 입력
        String checkOut = helper.inputDateTime("체크아웃");
        if (checkOut == null) return null;

        // 체크인 < 체크아웃 검증
        try {
            DateValidator.validateTimeRange(checkIn, checkOut, true);
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
            System.out.println("체크인/체크아웃을 다시 입력해주세요.");
            return inputAccommodationInfo(tripId); // 재시도
        }

        // Itinerary 객체 생성 후 숙박정보 세팅
        Itinerary itinerary = new Itinerary(tripId, "A");
        itinerary.setAccommodationInfo(checkIn, checkOut);

        return itinerary;
    }
}
