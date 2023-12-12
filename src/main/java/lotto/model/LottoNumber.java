package lotto.model;

import java.util.Objects;
import lotto.util.validator.LottoNumberValidator;

public record LottoNumber(int number) implements Comparable<LottoNumber> {
    public LottoNumber {
        LottoNumberValidator.validate(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public boolean equals(Object obj) {
        LottoNumber that = (LottoNumber) obj;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
