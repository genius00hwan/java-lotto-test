package lotto.model;

import static lotto.exception.Messages.DUPLICATE_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateDuplication(numbers);
    }
    // TODO: 추가 기능 구현

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        numbers.stream()
                .filter(number -> !uniqueNumbers.add(number))
                .findFirst()
                .ifPresent(duplicate -> {
                    throw new LottoException(DUPLICATE_NUMBER);
                });

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }

    public Boolean contains(Integer target) {
        return numbers.contains(target);
    }
}
