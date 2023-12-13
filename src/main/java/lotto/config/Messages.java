package lotto.config;

public enum Messages {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    NUMBER_OF_LOTTO_FORMAT("%d개를 구매했습니다.\n"),
    RANK_FORMAT("%d개 일치 %s(%,d원) - %d개\n"),
    BONUS_BALL("보너스 볼 일치 "),
    PROFIT_RATIO_FORMAT("총 수익률은 %.1f%입니다.\n"),
    RECEIPT_TITLE("당첨 통계\n---");
    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
