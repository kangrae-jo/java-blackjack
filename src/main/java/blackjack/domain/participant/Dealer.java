package blackjack.domain.participant;

import blackjack.domain.state.running.Init;

public final class Dealer extends Participant {

    protected static final String DEALER_NAME = "딜러";
    private static final int DEALER_CAN_DRAW_THRESHOLD = 17;

    public Dealer() {
        super(DEALER_NAME);
    }
    
    public boolean isInit() {
        return state instanceof Init;
    }

    @Override
    public boolean canDraw() {
        return state.cards().calculateSumOfCards() < DEALER_CAN_DRAW_THRESHOLD;
    }

}
