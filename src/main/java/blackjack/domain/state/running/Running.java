package blackjack.domain.state.running;

import blackjack.domain.card.Cards;
import blackjack.domain.state.Started;

public abstract class Running extends Started {

    public Running(final Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double amount) {
        throw new UnsupportedOperationException("아직 게임이 진행 중 입니다.");
    }

}
