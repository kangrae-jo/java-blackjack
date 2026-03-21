package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.state.State;
import blackjack.domain.state.finished.Burst;
import blackjack.domain.state.running.Init;
import blackjack.domain.state.running.Running;
import java.util.List;

public abstract class Participant {

    private final ParticipantName name;
    protected State state;

    public Participant(String name) {
        this.name = new ParticipantName(name);
        this.state = new Init(new Cards());
    }

    public final void draw(Card card) {
        state = state.draw(card);
    }

    public final boolean isBurst() {
        return state instanceof Burst;
    }

    public final void checkStay() {
        if (state instanceof Running) {
            state = state.stay();
        }
    }

    public final double profit(double amount) {
        return state.profit(amount);
    }

    public final int getScore() {
        return state.cards().calculateSumOfCards();
    }

    public final String getFirstCardName() {
        return state.cards().getFirstCardName();
    }

    public final List<String> getCardsName() {
        return state.cards().getCardsName();
    }

    public final String getName() {
        return name.name();
    }
    
    public abstract boolean canDraw();

}
