package baseball.view;

public class OutputVIew {

    public void printBeginningNotice() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHint(String result) {
        System.out.println(result);
    }

    public void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
