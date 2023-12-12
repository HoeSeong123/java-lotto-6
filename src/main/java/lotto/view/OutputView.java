package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Rank;

public class OutputView {
    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseLotto(List<Lotto> purchaseLotto) {
        System.out.println(purchaseLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchaseLotto) {
            System.out.println(lotto.getNumbers().stream()
                    .map(LottoNumber::number)
                    .toList());
        }
    }

    public static void printResult(Map<Rank, Integer> result) {
        List<Rank> ranks = Rank.valuesByRank();

        for (Rank rank : ranks) {
            String message = rank.getMessage();
            if (message.isBlank()) {
                continue;
            }

            System.out.println(message + " - " + result.getOrDefault(rank, 0) + "개");
        }
    }
}
