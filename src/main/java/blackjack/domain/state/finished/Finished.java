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
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double amount) {
        return 0;
    }

    public abstract double earningRate();

}
