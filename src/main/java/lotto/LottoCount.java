package lotto;

public class LottoCount {
    private static final int MODULER=1000;
    private final int lottoCount;

    public LottoCount(String money) {
        int lottoMoney = checkInt(money);
        checkNegative(lottoMoney);
        this.lottoCount = check1000(lottoMoney);
    }

    private int checkInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력되어야 합니다.");
        }
    }

    private int check1000(int money) {
        if (money % MODULER != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        return money / MODULER;
    }

    private void checkNegative(int money) {
        if (money <= 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
