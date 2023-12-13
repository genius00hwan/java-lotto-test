package lotto.config;

public enum Rank {

    FAIL(0, 0, 0, false),
    FIRST(1, 6, 2000000000, false),
    SECOND(2, 5, 30000000, true),
    THIRD(3, 5, 1500000, false),
    FOURTH(4, 4, 50000, false),
    FIFTH(5, 3, 5000, false);


    Rank(int rankNumber, int numberOfBalls, int prize, boolean bonus) {
        this.rankNumber = rankNumber;
        this.numberOfBalls = numberOfBalls;
        this.prize = prize;
        this.bonus = bonus;
    }

    private int rankNumber;
    private int numberOfBalls;
    private int prize;
    private boolean bonus;

    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static Rank getRank(Integer numberOfMatch, Boolean isBonus) {
        if (numberOfMatch == Rank.FIRST.getNumberOfBalls()) {
            return Rank.FIRST;
        }
        if (numberOfMatch == Rank.SECOND.getNumberOfBalls() && isBonus) {
            return Rank.SECOND;
        }
        if (numberOfMatch == Rank.THIRD.getNumberOfBalls()) {
            return Rank.THIRD;
        }
        if (numberOfMatch == Rank.FOURTH.getNumberOfBalls()) {
            return Rank.FOURTH;
        }
        if (numberOfMatch == Rank.FIFTH.getNumberOfBalls()) {
            return Rank.FIFTH;
        }

        return Rank.FAIL;

    }
}
