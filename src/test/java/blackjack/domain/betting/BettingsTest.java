package blackjack.domain.betting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardShape;
import blackjack.domain.card.CardValue;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BettingsTest {

    @Test
    void 베팅_정보_저장_기능_테스트() {
        // given
        Player player = new Player("밀란");
        int bettingAmount = 1_000;

        // when & then
        assertThatCode(() -> Bettings.of(Map.of(player, new BettingAmount(bettingAmount))))
                .doesNotThrowAnyException();
    }

    @Test
    void 플레이어와_상태를_알면_수익을_알_수_있다() {
        // given
        Player player = new Player("밀란");
        player.draw(new Card(CardValue.ACE, CardShape.CLOVER));
        player.draw(new Card(CardValue.JACK, CardShape.CLOVER));
        Dealer dealer = new Dealer();
        Bettings bettings = Bettings.of(Map.of(player, new BettingAmount(1_000)));

        // when
        int profit = (int) bettings.calculateProfit(player, dealer);

        // then
        assertThat(profit).isEqualTo(1_500);
    }

    @Test
    void 등록되지_않은_플레이어를_받으면_오류를_일으킨다() {
        // given
        Player player = new Player("밀란");
        Player other = new Player("없음");
        Dealer dealer = new Dealer();
        int bettingAmount = 1_000;
        Bettings bettings = Bettings.of(Map.of(player, new BettingAmount(bettingAmount)));

        // when & then
        assertThatThrownBy(() -> bettings.calculateProfit(other, dealer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어가_Stay일_때_딜러와_점수비교로_승부를_계산한다() {
        // given
        Player player = new Player("밀란");
        player.draw(new Card(CardValue.TEN, CardShape.CLOVER));
        player.draw(new Card(CardValue.TEN, CardShape.HEART));
        player.stay();

        Dealer dealer = new Dealer();
        dealer.draw(new Card(CardValue.NINE, CardShape.DIAMOND));
        dealer.draw(new Card(CardValue.NINE, CardShape.SPADE));

        Bettings bettings = Bettings.of(Map.of(player, new BettingAmount(1_000)));

        // when
        int profit = (int) bettings.calculateProfit(player, dealer);

        // then
        assertThat(profit).isEqualTo(1_000);
    }

}
