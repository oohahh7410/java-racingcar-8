package racingcar.domain;

public class Car {
    private static final String POSITION_SYMBOL = "-";
    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.position = INITIAL_POSITION;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        String trimmedName = name.trim();
        if (trimmedName.length() < MIN_NAME_LENGTH || trimmedName.length() > MAX_NAME_LENGTH) {
            // 테스트 로그에 맞춰 메시지 수정
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position += MOVE_DISTANCE;
        }
    }

    public boolean isAtPosition(int targetPosition) {
        return this.position == targetPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionDisplay() {
        return POSITION_SYMBOL.repeat(position);
    }
}