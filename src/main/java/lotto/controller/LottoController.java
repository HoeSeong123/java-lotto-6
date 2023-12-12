package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        int purchaseQuantity = purchaseAmount.getPurchaseQuantity();
        List<Lotto> purchaseLottos = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumbersGenerator());
        for (int i = 0; i < purchaseQuantity; i++) {
            purchaseLottos.add(lottoGenerator.createLotto());
        }

        OutputView.printPurchaseLotto(purchaseLottos);

        WinningLotto winningLotto = readWinningLotto();

    }

    private PurchaseAmount readPurchaseAmount() {
        return readWithRetry(() ->
                new PurchaseAmount(InputView.readPurchaseAmount()));
    }

    private WinningLotto readWinningLotto() {
        Lotto winningNumbers = readWinningNumbers();

        return readWithRetry(() ->
                new WinningLotto(
                        winningNumbers,
                        readBonusNumber()
                ));
    }

    private Lotto readWinningNumbers() {
        return readWithRetry(() ->
                new Lotto(InputView.readWinningNumbers()));
    }

    private LottoNumber readBonusNumber() {
        return readWithRetry(() ->
                new LottoNumber(InputView.readBonusNumber()));
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
