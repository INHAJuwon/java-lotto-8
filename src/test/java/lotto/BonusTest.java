package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    private Lotto createWinningLotto() {
        return new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("정상적인_보너스_번호를_생성하고_반환한다.")
    @Test
    void 보너스_번호_생성을_성공한다() {
        String input = "7";
        Lotto winningLotto = createWinningLotto();

        Bonus bonus = new Bonus(input, winningLotto);

        assertThat(bonus.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스_번호가_숫자가_아니면_예외가_발생한다.")
    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        Lotto winningLotto = createWinningLotto();

        assertThatThrownBy(() -> new Bonus("bonus", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스_번호가_당첨_번호와_중복되면_예외가_발생한다.")
    @Test
    void 보너스_번호_당첨_번호_중복시_예외가_발생한다() {
        Lotto winningLotto = createWinningLotto();

        assertThatThrownBy(() -> new Bonus("1", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
