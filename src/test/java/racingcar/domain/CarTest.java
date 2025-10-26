package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void create_NameTooLong_ThrowsException() {
        assertThatThrownBy(() -> new Car("pobiwoni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외가 발생한다")
    void create_NameBlank_ThrowsException() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상이면 전진한다")
    void move_Forward() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 3 이하면 멈춘다")
    void move_Stop() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("위치 표시가 하이픈(-)으로 올바르게 변환된다")
    void getPositionDisplay() {
        Car car = new Car("pobi");
        car.move(5);
        car.move(8);
        assertThat(car.getPositionDisplay()).isEqualTo("--");
    }

    @Test
    @DisplayName("isAtPosition이 현재 위치를 정확히 판별한다")
    void isAtPosition() {
        Car car = new Car("pobi");
        car.move(9);
        assertThat(car.isAtPosition(1)).isTrue();
        assertThat(car.isAtPosition(0)).isFalse();
    }
}