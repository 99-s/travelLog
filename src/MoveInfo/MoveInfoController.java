package MoveInfo;

import Itineraries.Itinerary;

public class MoveInfoController {
    public Itinerary moveInfoControllerRun(String tripId) {
        MoveInfoView moveInfoView = new MoveInfoView();
        return moveInfoView.inputMoveInfo(tripId);
    }
}
