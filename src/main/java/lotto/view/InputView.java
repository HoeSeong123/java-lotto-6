package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinningNumbersValidator;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        PurchaseAmountValidator.validate(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        WinningNumbersValidator.validate(input);

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
