package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {
    FIRST(1, 6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 5, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 4, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(5, 3, 50_000L, "3개 일치 (5,000원)"),
    NONE(6, 0, 0L, "");

    private int rank;
    private int correctCount;
    private long prize;
    private String message;

    Rank(int rank, int correctCount, long prize, String message) {
        this.rank = rank;
        this.correctCount = correctCount;
        this.prize = prize;
        this.message = message;
    }

    public static Rank findRank(int correctCount, boolean correctBonusNumber) {
        if (correctCount == 5 && correctBonusNumber) {
            return SECOND;
        }

        return valuesByRank().stream()
                .filter(rank -> rank.correctCount == correctCount)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public static List<Rank> valuesByRank() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(rank -> -rank.rank))
                .toList();
    }
}
