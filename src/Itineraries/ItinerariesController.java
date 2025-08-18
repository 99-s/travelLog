package Itineraries;

import AccommodationInfo.AccommodationInfoController;
import AccommodationInfo.AccommodationInfoView;
import AccommodationInfo.AccommodationItinerary;
import MoveInfo.MoveInfoController;
import MoveInfo.MoveInfoView;
import MoveInfo.MoveItinerary;

import java.util.List;

public class ItinerariesController {
    private final ItinerariesView itinerariesView;
    private final AccommodationInfoController accommodationInfoController;
    private final MoveInfoController moveInfoController;
    private final ItinerariesService itinerariesService;
    private MoveItinerary moveItinerary;
    private MoveInfoView moveInfoView;
    private AccommodationItinerary accommodationItinerary;
    private AccommodationInfoView accommodationInfoView;

    public ItinerariesController(ItinerariesView itinerariesView,
                                 AccommodationInfoController accommodationInfoController,
                                 MoveInfoController moveInfoController,
                                 AccommodationInfoView accommodationInfoView,
                                 MoveInfoView moveInfoView,
                                 ItinerariesService itinerariesService) {
        this.itinerariesView = itinerariesView;
        this.accommodationInfoController = accommodationInfoController;
        this.moveInfoController = moveInfoController;
        this.accommodationInfoView = accommodationInfoView;
        this.moveInfoView = moveInfoView;
        this.itinerariesService = itinerariesService;
    }


    //여정조회
    public void showAllItineraries() {
        String tripId = itinerariesView.askTripId(); // 조회할 여행 ID 입력
        List<Itinerary> itineraries = itinerariesService.getItinerariesByTrip(tripId);

        if (itineraries.isEmpty()) {
           System.out.println("해당 여행의 여정이 없습니다.");
        } else {
            System.out.println("=== " + tripId + " 여행의 여정 목록 ===");
            itinerariesView.printItineraries(tripId,itineraries);
        }
    }

    public void recordItineraries() {
        itinerariesView.printWelcomeMessage();
        String tripId = itinerariesView.askTripId();

        while (itinerariesView.askYesNo("여정을 입력하시겠습니까?")) {
            Itinerary itinerary = new Itinerary(tripId, "");
            boolean hasMove = false;
            boolean hasStay = false;

            // 이동 정보 입력 여부 확인
            if (itinerariesView.askYesNo("이동 정보를 입력하시겠습니까?")) {
                MoveItinerary moveItinerary = moveInfoView.inputMoveInfo(tripId);
                if (moveItinerary != null) {
                    itinerary.setDeparturePlace(moveItinerary.getDeparturePlace());
                    itinerary.setDestination(moveItinerary.getDestination());
                    itinerary.setDepartureTime(moveItinerary.getDepartureTime());
                    itinerary.setArrivalTime(moveItinerary.getArrivalTime());
                    hasMove = true;
                }
            }

            // 숙박 정보 입력 여부 확인
            if (itinerariesView.askYesNo("숙박 정보를 입력하시겠습니까?")) {
                AccommodationItinerary accItinerary = accommodationInfoView.inputAccommodationInfo(tripId);
                if (accItinerary != null) {
                    itinerary.setCheckIn(accItinerary.getCheckIn());
                    itinerary.setCheckOut(accItinerary.getCheckOut());
                    hasStay = true;
                }
            }

            // 여정 타입 설정 (M, A, MA 가능)
            if (hasMove && hasStay) {
                itinerary.setType("MA"); // 혼합도 표시하고 싶다면 이렇게
            } else if (hasMove) {
                itinerary.setType("M");
            } else if (hasStay) {
                itinerary.setType("A");
            }

            // 정보가 하나라도 있으면 저장
            if (hasMove || hasStay) {
                itinerariesService.saveItinerary(itinerary);
            } else {
                System.out.println("입력된 여정 정보가 없어 저장되지 않았습니다.");
            }
        }
    }



    private boolean hasData(Itinerary itinerary) {
        return itinerary.getDeparturePlace() != null || itinerary.getCheckIn() != null;
    }
}
