package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionTest {

    @DisplayName("구입한_개수만큼_로또를_정상적으로_생성하는지_확인한다.")
    @Test
    void 로또_개수를_확인한다() {
        int lottoCount = 5;
        Selection selection = new Selection(lottoCount);

        assertThat(selection.getSelection()).hasSize(lottoCount);
    }
}
