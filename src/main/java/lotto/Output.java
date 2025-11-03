package lotto;

import java.util.List;
import java.util.Map;

public class Output {
    public static void printLotto(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    static void printList(List<Integer> list) {
        StringBuilder printer = new StringBuilder();
        for (int num = 0; num < list.size(); num++) {
            if (num > 0) {
                printer.append(", ");
            }
            printer.append(list.get(num));
        }
        System.out.println('[' + printer.toString() + ']');
    }

    public static void printResults(Map<LottoEnum, Integer> winningResult) {
        System.out.println("\n당첨 통계\n---");

        for (LottoEnum rank : LottoEnum.values()) {
            if (!rank.isWinningRank()) {
                continue;
            }

            int count = winningResult.getOrDefault(rank, 0);

            System.out.printf("%s - %d개\n", rank.getMessage(), count);
        }

    }

    public static void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenue);
    }
}
