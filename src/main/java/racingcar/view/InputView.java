package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_PROMPT = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
    private static final String ROUND_PROMPT = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static String readCarNames() {
        System.out.println(CAR_PROMPT);
        return Console.readLine();
    }

    public static String readRoundCount() {
        System.out.println(ROUND_PROMPT);
        return Console.readLine();
    }
}