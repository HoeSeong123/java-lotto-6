package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseLotto(List<Lotto> purchaseLotto) {
        System.out.println(purchaseLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchaseLotto) {
            System.out.println(lotto.getNumbers());
        }
    }
}
