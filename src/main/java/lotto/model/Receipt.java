package lotto.model;

import static lotto.config.Constants.PURCHASE_UNIT;

import java.util.List;
import java.util.Map;
import lotto.config.Rank;

public class Receipt {
    Integer purchaseAmount;
    Map<Rank, Integer> numberOfRank;

    public Receipt(Integer numberOfLotto, Map<Rank, Integer> numberOfRank) {
        this.purchaseAmount = numberOfLotto * PURCHASE_UNIT.get();
        this.numberOfRank = numberOfRank;
    }

    public Integer getNumberOfRank(Rank rank) {
        return numberOfRank.get(rank);
    }

    public Double getProfitRatio() {
        Long totalPrize = calculateTotalPrize();
        return ((double) totalPrize / (double) purchaseAmount) * 100.0;
    }

    private Long calculateTotalPrize() {
        Long totalPrize = 0L;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * numberOfRank.get(rank);
        }
        return totalPrize;
    }
}
