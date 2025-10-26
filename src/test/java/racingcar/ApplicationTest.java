package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,javaji", "1");
                    assertThat(output()).contains("오류가 발생했습니다: 자동차 이름은 5자 이하여야 합니다.");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
