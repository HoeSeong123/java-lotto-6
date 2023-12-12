package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.validator.LottoValidator;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }

    public boolean contains(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public int compare(Lotto purchaseLotto) {
        return (int) this.numbers.stream()
                .filter(number -> purchaseLotto.getNumbers().contains(number))
                .count();
    }
}
