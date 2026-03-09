package blackjack.domain;

import java.util.List;

public class User {

    private static final int BLACKJACK_VALUE = 21;

    private final UserName name;
    private final Cards cards;

    public User(String name) {
        this.name = new UserName(name);
        this.cards = new Cards();
    }

    public void bring(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name.name();
    }

    public String getFirstCardName() {
        return cards.getFirstName();
    }

    public List<String> getCardsName() {
        return cards.getNames();
    }

    public int calculateCardsValue() {
        return cards.calculateValue();
    }

    public boolean isBurst() {
        return calculateCardsValue() > BLACKJACK_VALUE;
    }

    private boolean isBlackjack() {
        return calculateCardsValue() == BLACKJACK_VALUE;
    }

    public boolean isFinished() {
        return isBurst() || isBlackjack();
    }
}
