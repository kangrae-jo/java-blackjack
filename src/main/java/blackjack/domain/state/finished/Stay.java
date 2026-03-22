package blackjack.domain.state.finished;

import blackjack.domain.card.Cards;
import blackjack.domain.participant.Dealer;

public final class Stay extends Finished {

    private static final double DRAW_EARNING_RATE = 0.0;

    public Stay(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1.0;
    }

    @Override
    public double profit(Dealer dealer, double amount) {
        if (dealer.isBurst()) {
            return amount * earningRate();
        }
        int playerScore = cards.calculateSumOfCards();
        int dealerScore = dealer.getScore();
        if (playerScore < dealerScore) {
            return amount * (-earningRate());
        }
        return amount * earningRate();
    }

}
