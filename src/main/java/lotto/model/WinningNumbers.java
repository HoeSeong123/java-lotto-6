package lotto.model;

import java.util.List;
import lotto.util.validator.WinningNumbersValidator;

public record WinningNumbers(List<Integer> winningNumbers) {
    public WinningNumbers {
        WinningNumbersValidator.validate(winningNumbers);
    }
}
