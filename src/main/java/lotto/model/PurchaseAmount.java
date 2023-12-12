package lotto.model;

import lotto.util.validator.PurchaseAmountValidator;

public record PurchaseAmount(int purchaseAmount) {
    public PurchaseAmount {
        PurchaseAmountValidator.validate(purchaseAmount);
    }

    public int getPurchaseQuantity() {
        return purchaseAmount / 1_000;
    }
}
