package lotto.view;

import static lotto.config.Messages.INPUT_BONUS_NUMBER;
import static lotto.config.Messages.INPUT_PURCHASE_AMOUNT;
import static lotto.config.Messages.INPUT_WINNING_NUMBERS;
import static lotto.exception.Messages.NOT_INTEGER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.InputException;

public class InputView {

    private static final String REGEX = ",";

    private static class SingletonInputView {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return SingletonInputView.INPUT_VIEW;
    }

    private InputView() {

    }

    public Integer inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.get());
        String userInput = Console.readLine();
        return parseInt(userInput);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.get());
        String userInput = Console.readLine();

        List<String> userInputList = parseList(userInput);
        List<Integer> winningNumbers = parseIntList(userInputList);

        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.get());
        String userInput = Console.readLine();

        return parseInt(userInput);
    }

    private List<Integer> parseIntList(List<String> userInputList) {
        List<Integer> integerList = new ArrayList<>();
        for (String string : userInputList) {
            integerList.add(parseInt(string));
        }
        return integerList;
    }

    private List<String> parseList(String userInput) {
        return List.of(userInput.split(REGEX));
    }

    private Integer parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new InputException(NOT_INTEGER);
        }
    }

}
