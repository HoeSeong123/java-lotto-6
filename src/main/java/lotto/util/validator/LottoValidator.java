package lotto.util.validator;

import static lotto.util.constants.GameConstants.LOTTO_SIZE;
import static lotto.util.constants.GameConstants.MAX_NUMBER;
import static lotto.util.constants.GameConstants.MIN_NUMBER;
import static lotto.util.message.ExceptionMessage.INVALID_IS_DUPLICATE;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_AVAILABLE_SIZE;
import static lotto.util.message.ExceptionMessage.INVALID_OUT_OF_RANGE;

import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        for (int number : numbers) {
            validateIsInRange(number);
        }
        validateIsDuplicate(numbers);
        validateIsAvailableSize(numbers);
    }

    private static void validateIsDuplicate(List<Integer> numbers) {
        List<Integer> distinctElements = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctElements.size()) {
            throw new IllegalArgumentException(INVALID_IS_DUPLICATE.getMessage());
        }
    }

    private static void validateIsInRange(int number) {
        if (number < MIN_NUMBER.get() || number > MAX_NUMBER.get()) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateIsAvailableSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.get()) {
            throw new IllegalArgumentException(INVALID_NOT_AVAILABLE_SIZE.getMessage());
        }
    }
}
