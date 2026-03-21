package blackjack.domain.state.finished;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.Started;
import blackjack.domain.state.State;

public abstract class Finished extends Started {

    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        throw new UnsupportedOperationException("더 이상 카드를 뽑을 수 없습니다.");
    }

    @Override
    public State stay() {
        throw new UnsupportedOperationException("이미 완료된 동작입니다.");
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double amount) {
        return amount * earningRate();
    }

    public abstract double earningRate();

}
