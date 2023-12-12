package lotto.model;

import java.util.Map;

public class Result {
    private Map<Rank, Integer> rankResult;
    private double prizeRate;

    public Result(Map<Rank, Integer> rankResult, PurchaseAmount purchaseAmount) {
        this.rankResult = rankResult;
        prizeRate = calculatePrizeRate(purchaseAmount.purchaseAmount());
    }

    private double calculatePrizeRate(int purchaseAmount) {
        long totalPrize = 0L;

        for (Rank rank : rankResult.keySet()) {
            totalPrize += (long) rankResult.get(rank) * rank.getPrize();
        }

        return (double) totalPrize / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }

    public double getPrizeRate() {
        return prizeRate;
    }
}
