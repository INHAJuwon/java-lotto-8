package lotto;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
    public List<Integer> splitNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            trimming(number);
            numbers.add(checkInt(number));
        }
        return numbers;
    }

    private void trimming(String number) {
        String trimmedNumber = number.trim();
        if (trimmedNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,) 사이에 빈 값이 올 수 없습니다.");
        }
    }

    private int checkInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
