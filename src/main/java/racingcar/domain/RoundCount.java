package racingcar.domain;

public class RoundCount {
    private static final int MIN_ROUND = 1;
    private static final String EMPTY_INPUT_ERROR = "시도 횟수를 입력해 주세요.";
    private static final String INVALID_FORMAT_ERROR = "시도 횟수는 숫자만 입력할 수 있습니다.";
    private static final String INVALID_RANGE_ERROR = "시도 횟수는 1 이상이어야 합니다.";

    private final int value;

    public RoundCount(String input) {
        validateNotEmpty(input);
        this.value = parseAndValidate(input);
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private int parseAndValidate(String input) {
        int parsedValue = parse(input);
        validateRange(parsedValue);
        return parsedValue;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
    }

    private void validateRange(int value) {
        if (value < MIN_ROUND) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }
    }

    public int getValue() {
        return value;
    }
}