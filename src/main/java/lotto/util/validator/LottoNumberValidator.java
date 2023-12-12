package lotto.util.validator;

import static lotto.util.constants.GameConstants.MAX_NUMBER;
import static lotto.util.constants.GameConstants.MIN_NUMBER;
import static lotto.util.message.ExceptionMessage.INVALID_OUT_OF_RANGE;

public class LottoNumberValidator {
    public static void validate(int number) {
        validateIsInRange(number);
    }

    private static void validateIsInRange(int number) {
        if (number < MIN_NUMBER.get() || number > MAX_NUMBER.get()) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getMessage());
        }
    }
}
