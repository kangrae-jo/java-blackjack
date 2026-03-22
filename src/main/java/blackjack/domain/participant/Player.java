package blackjack.domain.participant;

public final class Player extends Participant {

    public Player(String name) {
        super(name);
    }

    public double profit(Dealer dealer, double amount) {
        return state.profit(dealer, amount);
    }

    @Override
    public boolean canDraw() {
        return !state.isFinished();
    }

}
