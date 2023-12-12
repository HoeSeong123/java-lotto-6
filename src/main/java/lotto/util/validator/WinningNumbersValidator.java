package lotto.util.validator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator {
    public static void validate(String input) {
        List<String> numbers = Arrays.stream(input.split(",")).toList();
    }
}
