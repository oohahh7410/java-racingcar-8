package racingcar.domain;

import racingcar.util.RandomUtils;
import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String input) {
        List<String> names = parseNames(input);
        validateDuplicate(names);
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<String> parseNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> names) {
        Set<String> unique = new HashSet<>(names);
        if (unique.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(RandomUtils.getRandomNumber());
        }
    }

    public List<String> getWinners() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.isAtPosition(max))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}