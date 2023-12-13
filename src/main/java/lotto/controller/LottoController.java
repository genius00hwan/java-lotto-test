package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.config.Rank;
import lotto.model.PurchaseAmount;
import lotto.model.Receipt;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.service.AutoLottoService;
import lotto.service.JudgeService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static class SingletonLottoController {
        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    public static LottoController getInstance() {
        return SingletonLottoController.LOTTO_CONTROLLER;
    }


    private static InputView inputView;
    private static OutputView outputView;
    private static AutoLottoService autoLottoService;
    private static JudgeService judgeService;

    private LottoController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        autoLottoService = AutoLottoService.getInstance();
        judgeService = JudgeService.getInstance();
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<UserLotto> userLottoList = purchaseLotto(purchaseAmount);
        WinningLotto winningLotto = readWinningLotto();
        Receipt receipt = checkLottoList(winningLotto, userLottoList);
        printResult(receipt);

    }

    private PurchaseAmount readPurchaseAmount() {
        PurchaseAmount purchaseAmount;
        try {
            purchaseAmount = new PurchaseAmount(inputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            purchaseAmount = readPurchaseAmount();
        }
        return purchaseAmount;
    }

    private List<UserLotto> purchaseLotto(PurchaseAmount purchaseAmount) {
        List<UserLotto> userLottoList = autoLottoService.generateLottoList(purchaseAmount.getNumberOfLotto());
        List<List<Integer>> userNumberList = new ArrayList<>();
        for (UserLotto userLotto : userLottoList) {
            userNumberList.add(userLotto.getNumbers());
        }
        outputView.printPurchaseInformation(purchaseAmount.getNumberOfLotto(), userNumberList);
        return userLottoList;
    }


    private WinningLotto readWinningLotto() {
        WinningLotto winningLotto;
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            Integer bonusNumber = inputView.inputBonusNumber();
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            winningLotto = readWinningLotto();
        }
        return winningLotto;
    }

    private Receipt checkLottoList(WinningLotto winningLotto, List<UserLotto> userLottoList) {
        return judgeService.judge(winningLotto, userLottoList);
    }

    private void printResult(Receipt receipt) {
        outputView.printTitle();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.FAIL) {
                outputView.printRank(rank.getNumberOfBalls(), rank.getPrize(),
                        receipt.getNumberOfRank(rank), rank.isBonus());
            }
        }
        outputView.printProfitRatio(receipt.getProfitRatio());
    }
}
