package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundCountTest {

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    void create_NotANumber_ThrowsException() {
        assertThatThrownBy(() -> new RoundCount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하면 예외가 발생한다")
    void create_LessThanOne_ThrowsException() {
        assertThatThrownBy(() -> new RoundCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 공백이면 예외가 발생한다")
    void create_BlankInput_ThrowsException() {
        assertThatThrownBy(() -> new RoundCount(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 입력해 주세요.");
    }

    @Test
    @DisplayName("올바른 입력 시 숫자를 반환한다")
    void create_Success() {
        RoundCount roundCount = new RoundCount(" 5 ");
        assertThat(roundCount.getValue()).isEqualTo(5);
    }
}
