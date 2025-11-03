package lotto;

public class Bonus {
    private final int bonusNumber;

    public Bonus(String bonus, Lotto winning) {
        int bonusNumber = checkInt(bonus);
        checkDuplication(bonusNumber, winning);
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplication(int bonus, Lotto winning) {
        if (winning.containBonus(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중첩될 수 없습니다.");
    }

    private int checkInt(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
