package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String EMPTY_INPUT_ERROR = "자동차 이름을 입력해 주세요.";
    private static final String DUPLICATE_NAME_ERROR = "자동차 이름은 중복될 수 없습니다.";
    private static final int FIRST_INDEX = 0;

    private final List<Car> cars;

    public Cars(String input) {
        List<String> names = parseNames(input);
        validateDuplicates(names);
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<String> parseNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
        return List.of(input.split(","))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateDuplicates(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = RandomUtils.getRandomNumber();
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(FIRST_INDEX);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}