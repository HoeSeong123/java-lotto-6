package lotto.model;

import lotto.util.validator.LottoNumberValidator;

public record LottoNumber(int bonusNumber) {
    public LottoNumber {
        LottoNumberValidator.validate(bonusNumber);
    }
}
