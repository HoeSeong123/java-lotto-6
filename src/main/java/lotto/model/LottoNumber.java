package lotto.model;

import lotto.util.validator.LottoNumberValidator;

public record LottoNumber(int number) implements Comparable<LottoNumber> {
    public LottoNumber {
        LottoNumberValidator.validate(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }
}
