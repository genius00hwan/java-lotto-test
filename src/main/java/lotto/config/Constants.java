package lotto.config;

public enum Constants {
    PURCHASE_UNIT(1000),
    MINIMUM_OF_RANGE(1),
    MAXIMUM_OF_RANGE(45),
    LENGTH_OF_LOTTO(6)
    ;
    private int value;

    Constants(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
