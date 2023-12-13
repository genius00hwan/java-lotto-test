package lotto.model;

import static lotto.config.Constants.PURCHASE_UNIT;
import static lotto.exception.Messages.INVALID_UNIT_ERROR;
import static lotto.exception.Messages.NEGATIVE_PURCHASE_ERROR;

import lotto.exception.InputException;

public class PurchaseAmount {
    private Integer purchaseAmount;

    public PurchaseAmount(Integer purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }


    public Integer getNumberOfLotto() {
        return purchaseAmount / PURCHASE_UNIT.get();
    }

    private void validatePurchaseAmount(Integer purchaseAmount) {
        validateSign(purchaseAmount);
        validateUnit(purchaseAmount);
    }

    private void validateSign(Integer purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new InputException(NEGATIVE_PURCHASE_ERROR);
        }
    }

    private void validateUnit(Integer purchaseAmount) {
        if (purchaseAmount % PURCHASE_UNIT.get() != 0) {
            throw new InputException(INVALID_UNIT_ERROR);
        }
    }
}
