package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private final Splitter splitter;

    public Input(Splitter splitter) {
        this.splitter = splitter;
    }

    public String readPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> selectWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return splitter.splitNumbers(input);
    }

    public String readBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
