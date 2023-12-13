package lotto.exception;

import static lotto.exception.Messages.ERROR_HEADER;

public class LottoException extends IllegalArgumentException {

    public LottoException(Messages message) {
        super(ERROR_HEADER.get() + message.get());
    }
}
