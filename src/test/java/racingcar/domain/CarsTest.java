package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("입력된 문자열로 Car 리스트를 생성한다")
    void create_Success() {
        Cars cars = new Cars("pobi,woni,jun");
        List<Car> carList = cars.getCars();

        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다")
    void create_DuplicateNames_ThrowsException() {
        assertThatThrownBy(() -> new Cars("pobi,woni,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복될 수 없습니다.");
    }

    @Test
    @DisplayName("입력값이 공백이면 예외가 발생한다")
    void create_BlankInput_ThrowsException() {
        assertThatThrownBy(() -> new Cars(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해 주세요.");
    }

    @Test
    @DisplayName("moveAll 호출 시 모든 차가 움직이거나 멈춘다")
    void moveAll() {
        Cars cars = new Cars("pobi,woni");

        assertRandomNumberInRangeTest(cars::moveAll, 4, 3);

        List<Car> carList = cars.getCars();
        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isZero();
    }

    @Test
    @DisplayName("단독 우승자를 올바르게 반환한다")
    void getWinners_SingleWinner() {
        Cars cars = new Cars("pobi,woni,jun");

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAll();
                    cars.moveAll();
                },
                5, 3, 1,
                8, 2, 6
        );

        // pobi: 1 -> 2
        // woni: 0 -> 0
        // jun:  0 -> 1

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자를 올바르게 반환한다")
    void getWinners_MultipleWinners() {
        Cars cars = new Cars("pobi,woni,jun");

        assertRandomNumberInRangeTest(cars::moveAll, 5, 2, 5);

        // pobi: 1
        // woni: 0
        // jun:  1

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactly("pobi", "jun");
    }
}