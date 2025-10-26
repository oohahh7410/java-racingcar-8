package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGameController controller = new RacingGameController();
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
    }
}