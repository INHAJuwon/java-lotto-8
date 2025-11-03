package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private Result result;
    private Lotto winningLotto;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        result = new Result();
        winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        bonusNumber = 7;
    }

    private Lotto createLotto(int n1, int n2, int n3, int n4, int n5, int n6) {
        return new Lotto(new ArrayList<>(List.of(n1, n2, n3, n4, n5, n6)));
    }

    @DisplayName("다양한_등수의_로또_당첨을_계산한다.")
    @Test
    void 로또_당첨을_계산한다() {
        List<Lotto> purchasedLottos = List.of(
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 2, 3, 4, 5, 7),
                createLotto(1, 2, 3, 4, 5, 8),
                createLotto(1, 2, 3, 4, 9, 10),
                createLotto(1, 2, 3, 11, 12, 13),
                createLotto(1, 2, 14, 15, 16, 17),
                createLotto(20, 21, 22, 23, 24, 25)
        );

        result.calculateWinning(purchasedLottos, winningLotto, bonusNumber);
        Map<LottoEnum, Integer> calculatedResult = Map.of(
                LottoEnum.FIRST, 1,
                LottoEnum.SECOND, 1,
                LottoEnum.THIRD, 1,
                LottoEnum.FOURTH, 1,
                LottoEnum.FIFTH, 1,
                LottoEnum.NONE, 2
        );

        assertThat(calculatedResult.get(LottoEnum.FIRST)).isEqualTo(1);
        assertThat(calculatedResult.get(LottoEnum.SECOND)).isEqualTo(1);
        assertThat(calculatedResult.get(LottoEnum.THIRD)).isEqualTo(1);
        assertThat(calculatedResult.get(LottoEnum.FOURTH)).isEqualTo(1);
        assertThat(calculatedResult.get(LottoEnum.FIFTH)).isEqualTo(1);
        assertThat(calculatedResult.get(LottoEnum.NONE)).isEqualTo(2);
    }

    @DisplayName("수익률을_계산한다.")
    @Test
    void 수익률을_계산한다() {
        List<Lotto> purchasedLottos = List.of(
                createLotto(1, 2, 3, 11, 12, 13),
                createLotto(1, 2, 3, 14, 15, 16),
                createLotto(1, 2, 3, 4, 9, 10)
        );
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(purchasedLottos);

        for (int i = 0; i < 7; i++) {
            lottoList.add(createLotto(10, 20, 30, 40, 41, 42));
        }

        result.calculateWinning(lottoList, winningLotto, bonusNumber);
        double revenue = result.calculateRevenue(10000 / 1000);

        assertThat(revenue).isEqualTo(600.0);
    }

    @DisplayName("당첨금이_없을_경우_수익률이_0.0을_반환하는지_확인한다.")
    @Test
    void 당첨금_없을_경우_수익률_0() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoList.add(createLotto(10, 20, 30, 40, 41, 42)); // 0개 일치 (NONE)
        }

        result.calculateWinning(lottoList, winningLotto, bonusNumber);
        double revenue = result.calculateRevenue(10000 / 1000);

        assertThat(revenue).isEqualTo(0.0);
    }
}
