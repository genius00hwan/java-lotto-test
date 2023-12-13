package lotto.view;

import static lotto.config.Messages.BONUS_BALL;
import static lotto.config.Messages.PROFIT_RATIO_FORMAT;
import static lotto.config.Messages.RANK_FORMAT;
import static lotto.config.Messages.NUMBER_OF_LOTTO_FORMAT;
import static lotto.config.Messages.RECEIPT_TITLE;


import java.util.List;

public class OutputView {
    private static class SingletonOutputView {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return SingletonOutputView.OUTPUT_VIEW;
    }

    private OutputView() {

    }

    public void printPurchaseInformation(Integer numberOfLotto, List<List<Integer>> userLottoList) {
        System.out.printf(NUMBER_OF_LOTTO_FORMAT.get(), numberOfLotto);
        for (List<Integer> userNumbers : userLottoList) {
            System.out.println(userNumbers);
        }
    }

    public void printTitle() {
        System.out.println(RECEIPT_TITLE.get());
    }

    public void printRank(Integer numberOfBall, Integer prize, Integer numberOfRank, Boolean isBonus) {
        String bonusString = "";
        if (isBonus) {
            bonusString = BONUS_BALL.get();
        }
        System.out.printf(RANK_FORMAT.get(), numberOfBall, bonusString, prize, numberOfRank);

    }

    public void printProfitRatio(Double profitRatio) {
        System.out.printf(PROFIT_RATIO_FORMAT.get(), profitRatio);
    }
}
