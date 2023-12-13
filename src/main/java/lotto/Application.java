package lotto;

import lotto.controller.LottoController;

public class Application {
    private static LottoController lottoController;
    public static void main(String[] args) {
        lottoController = LottoController.getInstance();
        lottoController.run();
    }
}
