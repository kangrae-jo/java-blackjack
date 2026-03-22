package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;

public final class Burst extends Finished {

    public Burst(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return -1.0;
    }

}
