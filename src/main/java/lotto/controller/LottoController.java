package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        int purchaseQuantity = purchaseAmount / 1_000;
        List<Lotto> purchaseLotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumbersGenerator());
        for (int i = 0; i < purchaseQuantity; i++) {
            purchaseLotto.add(lottoGenerator.createLotto());
        }

        OutputView.printPurchaseLotto(purchaseLotto);

        List<Integer> winningNumbers = readWinningNumbers();
        System.out.println(winningNumbers);
    }

    private int readPurchaseAmount() {
        return readWithRetry(InputView::readPurchaseAmount);
    }

    private List<Integer> readWinningNumbers() {
        return readWithRetry(InputView::readWinningNumbers);
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
