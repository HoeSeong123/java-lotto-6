package lotto.view;

import static lotto.util.message.ExceptionMessage.INVALID_NOT_NUMERIC;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateIsNumeric(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> numbers = Arrays.stream(input.split(",")).toList();
        for (String number : numbers) {
            validateIsNumeric(number);
        }
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String input = Console.readLine();
        validateIsNumeric(input);

        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit) || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NOT_NUMERIC.getMessage());
        }
    }
}
