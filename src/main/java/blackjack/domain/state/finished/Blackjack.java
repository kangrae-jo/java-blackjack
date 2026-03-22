package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;

public final class Blackjack extends Finished {

    public Blackjack(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1.5;
    }

}
