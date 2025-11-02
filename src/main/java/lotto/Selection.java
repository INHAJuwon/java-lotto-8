package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Selection {
    private final List<Lotto> selection;

    public Selection(int count) {
        this.selection = selectLotto(count);
    }

    private List<Lotto> selectLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(generateRandom());
        }
        return lotto;
    }

    private Lotto generateRandom() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }

    public List<Lotto> getSelection() {
        return selection;
    }
}
