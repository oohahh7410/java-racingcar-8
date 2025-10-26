package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RoundCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void run() {
        String carNames = InputView.readCarNames();
        String roundInput = InputView.readRoundCount();

        Cars cars = new Cars(carNames);
        RoundCount roundCount = new RoundCount(roundInput);

        OutputView.printResultHeader();

        for (int i = 0; i < roundCount.getValue(); i++) {
            cars.moveAll();
            OutputView.printRoundResult(cars);
        }

        OutputView.printWinners(cars.getWinners());
    }
}