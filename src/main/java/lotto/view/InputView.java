package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.PurchaseAmountValidator;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        PurchaseAmountValidator.validate(input);

        return Integer.parseInt(input);
    }
}
