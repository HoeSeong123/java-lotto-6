package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.INVALID_LESS_THAN_MINIMUM_PAYMENT;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_NUMERIC;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_UNIT_OF_PAYMENT;

public class PurchaseAmountValidator {

    public static void validate(String input) {
        validateIsNumeric(input);
        int number = Integer.parseInt(input);
        validateOverMinimumPayment(number);
        validateIsUnitOfMinimumPayment(number);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private static void validateOverMinimumPayment(int number) {
        if (number < 1_000) {
            throw new IllegalArgumentException(INVALID_LESS_THAN_MINIMUM_PAYMENT.getMessage());
        }
    }

    private static void validateIsUnitOfMinimumPayment(int number) {
        if (number % 1_000 != 0) {
            throw new IllegalArgumentException(INVALID_NOT_UNIT_OF_PAYMENT.getMessage());
        }
    }


}
