package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        int purchaseQuantity = purchaseAmount.getPurchaseQuantity();
        List<Lotto> purchaseLotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumbersGenerator());
        for (int i = 0; i < purchaseQuantity; i++) {
            purchaseLotto.add(lottoGenerator.createLotto());
        }

        OutputView.printPurchaseLotto(purchaseLotto);

        WinningNumbers winningNumbers = readWinningNumbers();
//        int bonusNumber = readBonusNumber(winningNumbers);
    }

    private PurchaseAmount readPurchaseAmount() {
        return readWithRetry(() ->
                new PurchaseAmount(InputView.readPurchaseAmount()));
    }

    private WinningNumbers readWinningNumbers() {
        return readWithRetry(() ->
                new WinningNumbers(InputView.readWinningNumbers()));
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
