package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;

public class Burst extends Finished {

    public Burst(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
    
}
