package lotto.exception;

import static lotto.exception.Messages.ERROR_HEADER;

public class InputException extends IllegalArgumentException {
    public InputException(Messages message) {
        super(ERROR_HEADER.get() + message.get());
    }
}
