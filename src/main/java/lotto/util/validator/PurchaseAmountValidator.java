package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.INVALID_NOT_NUMERIC;

public class PurchaseAmountValidator {

    public static void validate(String input) {
        validateIsNumeric(input);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NOT_NUMERIC.getMessage());
        }
    }
}
