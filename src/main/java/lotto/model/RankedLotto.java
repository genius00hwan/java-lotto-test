package lotto.model;

import lotto.config.Rank;


public class RankedLotto {
    private Rank rank;
    private UserLotto lotto;

    public RankedLotto(UserLotto lotto, Rank rank) {
        this.lotto = lotto;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }
}
