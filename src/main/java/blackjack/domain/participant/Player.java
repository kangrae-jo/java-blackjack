package blackjack.domain.participant;

import blackjack.domain.state.finished.Burst;

public final class Player extends Participant {

    public Player(String name) {
        super(name);
    }

    public boolean winsAgainst(Dealer other) {
        if (other.state instanceof Burst) {
            return true;
        }
        if (this.state instanceof Burst) {
            return false;
        }
        return other.getScore() < this.getScore();
    }

    @Override
    public boolean canDraw() {
        return !state.isFinished();
    }

}
