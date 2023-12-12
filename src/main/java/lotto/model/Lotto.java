package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.util.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }

    public boolean contains(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber.bonusNumber());
    }
}
