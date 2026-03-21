package blackjack.domain.state.running;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.State;
import blackjack.domain.state.finished.Blackjack;

public class Init extends Running {

    private static final int SIZE_OF_INITIAL_CARD = 2;

    public Init(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        cards.add(card);
        if (cards.size() < SIZE_OF_INITIAL_CARD) {
            return new Init(cards);
        }
        if (cards.isMaxScore()) {
            return new Blackjack(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        throw new UnsupportedOperationException("아직 카드 분배가 끝나지 않았습니다.");
    }

}
