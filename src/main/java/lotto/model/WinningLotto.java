package lotto.model;

import static lotto.exception.Messages.DUPLICATE_NUMBER;

import java.util.List;
import lotto.exception.LottoException;
import lotto.model.Lotto;

public class WinningLotto extends Lotto {
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (super.contains(bonusNumber)) {
            throw new LottoException(DUPLICATE_NUMBER);
        }
    }

    public Boolean isBonus(Integer number) {
        return bonusNumber.equals(number);
    }
}
