package lotto;

import java.util.List;
import java.util.Map;

public class Output {
    public void printLotto(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            printList(lotto.getNumbers());
        }
    }

    private void printList(List<Integer> list) {
        StringBuilder printer = new StringBuilder();
        for (int num = 0; num < list.size(); num++) {
            if (num > 0) {
                printer.append(", ");
            }
            printer.append(list.get(num));
        }
        System.out.println('[' + printer.toString() + ']');
    }

    public void printResults(Map<LottoEnum, Integer> winningResult) {
        System.out.println("\n당첨 통계\n---");

        for (LottoEnum rank : LottoEnum.values()) {
            if (!rank.isWinningRank()) {
                continue;
            }

            int count = winningResult.getOrDefault(rank, 0);

            System.out.printf("%s - %d개\n", rank.getMessage(), count);
        }

    }

    public void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenue);
    }
}
