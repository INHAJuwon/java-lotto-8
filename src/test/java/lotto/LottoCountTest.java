package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @DisplayName("정상적인 구입 금액으로 로또 개수를 정확히 계산한다.")
    @Test
    void 정상_금액으로_로또_개수를_계산한다() {
        String validMoney = "8000";
        LottoCount lottoCount = new LottoCount(validMoney);

        assertThat(lottoCount.calculateLottoCount()).isEqualTo(8);
    }

    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 숫자_아닌_값_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoCount("money"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 천원_단위_아닐_경우_예외가_발생한다() {
        LottoCount lottoCount = new LottoCount("1200");
        assertThatThrownBy(lottoCount::calculateLottoCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이거나 음수인 경우 예외가 발생한다.")
    @Test
    void 영_또는_음수_입력시_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoCount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
