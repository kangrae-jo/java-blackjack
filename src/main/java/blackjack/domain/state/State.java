package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.participant.Dealer;

public interface State {

    State draw(Card card);

    State stay();

    boolean isFinished();
    
    Cards cards();

    double profit(Dealer dealer, double amount);

}
