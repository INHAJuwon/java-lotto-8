package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또_번호의_개수가_6개_미만이면_예외가_발생한다.")
    @Test
    void 로또_번호_개수_미만시_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호_범위_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 0))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 일치하는 개수를 정확히 계산한다.")
    @Test
    void 당첨_번호와_일치_개수를_확인한다() {
        Lotto myLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 10, 20, 30)));
        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 11, 21, 31)));

        int matchCount = myLotto.match(winningLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("일치하는 번호가 하나도 없을 때 0을 반환한다.")
    @Test
    void 일치_번호가_없을_때_0을_반환한다() {
        Lotto myLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(10, 20, 30, 40, 41, 42)));

        int matchCount = myLotto.match(winningLotto);

        assertThat(matchCount).isEqualTo(0);
    }

    @DisplayName("로또 번호가 보너스 번호를 포함하는지 확인한다.")
    @Test
    void 보너스_번호_포함을_확인한다() {
        Lotto myLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 5;

        assertThat(myLotto.containBonus(bonusNumber)).isTrue();
    }

    @DisplayName("로또 번호가 보너스 번호를 포함하지 않는지 확인한다.")
    @Test
    void 보너스_번호_미포함을_확인한다() {
        Lotto myLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;

        assertThat(myLotto.containBonus(bonusNumber)).isFalse();
    }
}