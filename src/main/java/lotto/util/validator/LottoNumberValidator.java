package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.INVALID_OUT_OF_RANGE;

public class LottoNumberValidator {
    public static void validate(int number) {
        validateIsInRange(number);
    }

    private static void validateIsInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getMessage());
        }
    }
}
