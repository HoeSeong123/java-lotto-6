package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.INVALID_IS_DUPLICATE;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_AVAILABLE_SIZE;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_NUMERIC;
import static lotto.util.message.ExceptionMessage.INVALID_OUT_OF_RANGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    public static void validate(String input) {
        List<String> numbers = Arrays.stream(input.split(",")).toList();
        for (String number : numbers) {
            validateIsNumeric(number);
            validateIsInRange(number);
        }
        validateIsDuplicate(numbers);
        validateIsAvailableSize(numbers);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private static void validateIsDuplicate(List<String> numbers) {
        List<String> distinctElements = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctElements.size()) {
            throw new IllegalArgumentException(INVALID_IS_DUPLICATE.getMessage());
        }
    }

    private static void validateIsInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateIsAvailableSize(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NOT_AVAILABLE_SIZE.getMessage());
        }
    }
}
