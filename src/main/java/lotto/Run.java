package lotto;

import java.util.List;

public class Run {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private final Input input;
    private final Result result;

    public Run() {
        input = new Input();
        result = new Result();
    }

    public void run() {
        LottoCount lottoCount = readPurchaseCount();
        Selection purchasedLotto = new Selection(lottoCount.calculateLottoCount());
        Lotto winningLotto = readWinningLotto();
        Bonus bonusNumber = readBonusNumber(winningLotto);

        result.calculateWinning(purchasedLotto.getSelection(), winningLotto, bonusNumber.getBonusNumber());
        Output.printRevenue(result.calculateRevenue(lottoCount.calculateLottoCount()));
    }

    private LottoCount readPurchaseCount() {
        while (true) {
            try {
                String purchase = input.readPurchase();
                return new LottoCount(purchase);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private Lotto readWinningLotto() {
        while (true) {
            try {
                return new Lotto(input.selectWinningNumbers());
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private Bonus readBonusNumber(Lotto winning) {
        while (true) {
            try {
                return new Bonus(input.readBonus(), winning);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }
}
