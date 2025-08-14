package MoveInfo;

public class MoveInfoController {

    public void moveInfoControllerRun(){
        MoveInfoView moveInfoView = new MoveInfoView();
        MoveItinerary moveItinerary = moveInfoView.inputMoveInfo();

//        이 moveInfoModel 을 service로 넘김
//        service에서 itinerary Controller로 넘김
//        Trip에 전달해주는 건가?
    }


}
