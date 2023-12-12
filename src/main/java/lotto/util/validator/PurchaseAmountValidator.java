package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.INVALID_NOT_NUMERIC;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_UNIT_OF_PAYMENT;

public class PurchaseAmountValidator {

    public static void validate(String input) {
        validateIsNumeric(input);
        validateIsUnitOfMinimumPayment(input);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private static void validateIsUnitOfMinimumPayment(String input) {
        if (Integer.parseInt(input) % 1_000 != 0) {
            throw new IllegalArgumentException(INVALID_NOT_UNIT_OF_PAYMENT.getMessage());
        }
    }

}
