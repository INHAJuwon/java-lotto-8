package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        Collections.sort(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void checkDuplication(List<Integer> numbers) {
        Set<Integer> compare = new HashSet<>(numbers);
        if (compare.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복값이 있을 수 없습니다.");
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 값이어야 합니다.");
            }
        }
    }

    public int match(Lotto winning) {
        int count = 0;

        for (int number : winning.numbers) {
            count += matchWinning(number);
        }
        return count;
    }

    private int matchWinning(int number) {
        if (numbers.contains(number))
            return 1;
        return 0;
    }

    public boolean containBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
