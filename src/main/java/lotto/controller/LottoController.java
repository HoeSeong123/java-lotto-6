package lotto.controller;

import java.util.function.Supplier;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int purchaseAmount = readPurchaseAmount();
    }

    private int readPurchaseAmount() {
        return readWithRetry(InputView::readPurchaseAmount);
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
