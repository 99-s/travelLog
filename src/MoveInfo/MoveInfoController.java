
package MoveInfo;

public class MoveInfoController {
//    객체 생성 후 객체 리턴
    public MoveItinerary moveInfoControllerRun(){
        MoveInfoView moveInfoView = new MoveInfoView();

        return moveInfoView.inputMoveInfo();
    }

}


