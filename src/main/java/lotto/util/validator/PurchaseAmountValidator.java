package lotto.util.validator;

import static lotto.util.constants.GameConstants.MINIMUM_PAYMENT;
import static lotto.util.message.ExceptionMessage.INVALID_LESS_THAN_MINIMUM_PAYMENT;
import static lotto.util.message.ExceptionMessage.INVALID_NOT_UNIT_OF_PAYMENT;

public class PurchaseAmountValidator {

    public static void validate(int input) {
        validateOverMinimumPayment(input);
        validateIsUnitOfMinimumPayment(input);
    }

    private static void validateOverMinimumPayment(int number) {
        if (number < MINIMUM_PAYMENT.get()) {
            throw new IllegalArgumentException(INVALID_LESS_THAN_MINIMUM_PAYMENT.getMessage());
        }
    }

    private static void validateIsUnitOfMinimumPayment(int number) {
        if (number % MINIMUM_PAYMENT.get() != 0) {
            throw new IllegalArgumentException(INVALID_NOT_UNIT_OF_PAYMENT.getMessage());
        }
    }
}
