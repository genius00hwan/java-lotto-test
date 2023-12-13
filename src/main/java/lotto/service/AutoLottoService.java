package lotto.service;

import static lotto.config.Constants.LENGTH_OF_LOTTO;
import static lotto.config.Constants.MAXIMUM_OF_RANGE;
import static lotto.config.Constants.MINIMUM_OF_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.UserLotto;

public class AutoLottoService {
    private static class SingletonAutoLottoService {
        private static final AutoLottoService AUTO_LOTTO_SERVICE = new AutoLottoService();
    }

    public static AutoLottoService getInstance() {
        return SingletonAutoLottoService.AUTO_LOTTO_SERVICE;
    }

    private AutoLottoService() {
    }

    public List<UserLotto> generateLottoList(Integer numberOfLotto) {
        List<UserLotto> lottoList = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            UserLotto autoLotto = generateLotto();
            lottoList.add(autoLotto);
        }

        return lottoList;
    }

    private UserLotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_OF_RANGE.get(), MAXIMUM_OF_RANGE.get(), LENGTH_OF_LOTTO.get());
        return new UserLotto(randomNumbers);
    }
}
