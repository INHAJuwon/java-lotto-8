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
        Output.printLotto(count);

        for (int i = 0; i < count; i++) {
            List<Integer> printingLotto = generateRandom();
            lotto.add(new Lotto(printingLotto));
            Output.printList(printingLotto);
        }
        return lotto;
    }

    private List<Integer> generateRandom() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getSelection() {
        return selection;
    }
}
