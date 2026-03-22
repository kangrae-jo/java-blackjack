package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;

public final class Stay extends Finished {

    public Stay(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1.0;
    }

}
