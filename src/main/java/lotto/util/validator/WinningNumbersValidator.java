package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.INVALID_IS_DUPLICATE;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_AVAILABLE_SIZE;
import static lotto.util.message.ExceptionMessage.INVALID_OUT_OF_RANGE;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
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
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateIsAvailableSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NOT_AVAILABLE_SIZE.getMessage());
        }
    }
}
