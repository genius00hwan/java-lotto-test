package lotto.service;

import static lotto.config.Constants.LENGTH_OF_LOTTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.config.Rank;
import lotto.model.Receipt;
import lotto.model.RankedLotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;

public class JudgeService {
    private static class SingletonJudgeService {
        private static final JudgeService JUDGE_SERVICE = new JudgeService();
    }

    public static JudgeService getInstance() {
        return SingletonJudgeService.JUDGE_SERVICE;
    }

    private JudgeService() {
    }

    public Receipt judge(WinningLotto winningLotto, List<UserLotto> lottoList) {
        List<RankedLotto> rankedLottoList = rankLottoList(winningLotto, lottoList);
        Map<Rank, Integer> numberOfRank = countRank(rankedLottoList);

        return new Receipt(lottoList.size(), numberOfRank);
    }

    private Map<Rank, Integer> countRank(List<RankedLotto> rankedLottoList) {
        Map<Rank, Integer> numberOfRank = new HashMap<>();
        for (Rank rank : Rank.values()) {
            numberOfRank.put(rank, 0);
        }
        for (RankedLotto rankedLotto : rankedLottoList) {
            numberOfRank.replace(rankedLotto.getRank(), numberOfRank.get(rankedLotto.getRank()) + 1);
        }
        return numberOfRank;
    }

    private List<RankedLotto> rankLottoList(WinningLotto winningLotto, List<UserLotto> userLottoList) {
        List<RankedLotto> rankedLottoList = new ArrayList<>();
        for (UserLotto userLotto : userLottoList) {
            Rank rank = Rank.getRank(gradeLotto(winningLotto, userLotto), checkBonus(winningLotto, userLotto));
            rankedLottoList.add(new RankedLotto(userLotto, rank));
        }
        return rankedLottoList;
    }


    private Integer gradeLotto(WinningLotto winningLotto, UserLotto userLotto) {
        Integer numberOfMatch = 0;
        for (int index = 0; index < LENGTH_OF_LOTTO.get(); index++) {
            if (winningLotto.contains(userLotto.getNumber(index))) {
                numberOfMatch++;
            }
        }
        return numberOfMatch;
    }

    private Boolean checkBonus(WinningLotto winningLotto, UserLotto userLotto) {
        for (int index = 0; index < LENGTH_OF_LOTTO.get(); index++) {
            if (winningLotto.isBonus(userLotto.getNumber(index))) {
                return true;
            }
        }
        return false;
    }

}
