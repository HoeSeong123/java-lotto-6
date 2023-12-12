package lotto.model;

import static lotto.util.message.ExceptionMessage.INVALID_IS_DUPLICATE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateIsDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateIsDuplicate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_IS_DUPLICATE.getMessage());
        }
    }

    public Map<Rank, Integer> checkTotalResult(List<Lotto> lottos) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = checkResult(lotto);

            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private Rank checkResult(Lotto userLotto) {
        int correctCount = winningNumbers.compare(userLotto);
        boolean correctBonusNumber = userLotto.contains(bonusNumber);
        return Rank.findRank(correctCount, correctBonusNumber);
    }
}
