package lotto.exception;

public enum Messages {
    ERROR_HEADER("[ERROR]"),
    NOT_INTEGER("정수를 입력해주세요"),
    NEGATIVE_PURCHASE_ERROR("음수로 구매하실 수 없습니다."),
    INVALID_UNIT_ERROR("1000원 단위로 구매해주세요"),
    DUPLICATE_NUMBER("중복된 숫자 입니다.");
    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
