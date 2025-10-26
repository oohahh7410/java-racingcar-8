package racingcar.domain;

public class RoundCount {
    private static final int MIN_ROUND = 1;

    private final int value;

    public RoundCount(String input) {
        validate(input);
        this.value = parse(input);
    }

    private void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해 주세요.");
        }
    }

    private int parse(String input) {
        try {
            int count = Integer.parseInt(input.trim());
            if (count < MIN_ROUND) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}