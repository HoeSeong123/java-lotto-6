package lotto.model;

import lotto.util.NumbersGenerator;

public class LottoGenerator {
    private final NumbersGenerator numbersGenerator;

    public LottoGenerator(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lotto createLotto() {
        return new Lotto(numbersGenerator.generateNumbers());
    }
}
