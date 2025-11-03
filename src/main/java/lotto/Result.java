package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final int MODULUS = 10;
    private final Map<LottoEnum, Integer> result;

    public Result() {
        this.result = new EnumMap<>(LottoEnum.class);
        initializeMap();
    }

    public void calculateWinning(List<Lotto> lottoList, Lotto winning, int bonus) {
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.match(winning);
            boolean checkBonus = lotto.containBonus(bonus);
            LottoEnum correct = LottoEnum.calculate(matchCount, checkBonus);
            int correctCount = result.get(correct);

            result.replace(correct, correctCount, correctCount + 1);
        }
        Output.printResults(result);
    }

    private void initializeMap() {
        for (LottoEnum rank : LottoEnum.values()) {
            result.put(rank, 0);
        }
    }

    public double calculateRevenue(int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<LottoEnum, Integer> entry : result.entrySet()) {
            totalPrize += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount / MODULUS;
    }
}
