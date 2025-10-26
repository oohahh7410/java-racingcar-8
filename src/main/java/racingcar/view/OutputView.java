package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자: ";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + car.getPositionDisplay());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNER_PREFIX + String.join(", ", winners));
    }
}