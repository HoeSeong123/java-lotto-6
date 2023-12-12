package lotto.util;

import static lotto.util.constants.GameConstants.LOTTO_SIZE;
import static lotto.util.constants.GameConstants.MAX_NUMBER;
import static lotto.util.constants.GameConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.get(), MAX_NUMBER.get(), LOTTO_SIZE.get());
    }
}
