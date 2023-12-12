package lotto.util.constants;

public enum GameConstants {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_SIZE(6),
    MINIMUM_PAYMENT(1_000);

    private int value;

    GameConstants(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
