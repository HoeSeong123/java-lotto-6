package lotto.model;

import static lotto.util.constants.GameConstants.MINIMUM_PAYMENT;

import lotto.util.validator.PurchaseAmountValidator;

public record PurchaseAmount(int purchaseAmount) {
    public PurchaseAmount {
        PurchaseAmountValidator.validate(purchaseAmount);
    }

    public int getPurchaseQuantity() {
        return purchaseAmount / MINIMUM_PAYMENT.get();
    }
}
