package lotto.util.message;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_NOT_UNIT_OF_PAYMENT("1,000원 단위로 입력해야 합니다."),
    INVALID_LESS_THAN_MINIMUM_PAYMENT("최소 주문 금액은 1,000원입니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
