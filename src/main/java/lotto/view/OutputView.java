package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Rank;
import lotto.model.Result;

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

    public static void printResult(Result result) {
        printWinningDetails(result.getRankResult());
        printPrizeRate(result.getPrizeRate());
    }

    private static void printWinningDetails(Map<Rank, Integer> rankResult) {
        List<Rank> ranks = Rank.valuesByRank();

        for (Rank rank : ranks) {
            String message = rank.getMessage();
            if (message.isBlank()) {
                continue;
            }

            System.out.println(message + " - " + rankResult.getOrDefault(rank, 0) + "개");
        }
    }

    private static void printPrizeRate(double prizeRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", prizeRate);
    }
}
