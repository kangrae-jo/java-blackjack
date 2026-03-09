package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final int BLACKJACK_VALUE = 21;
    private static final int ACE_BONUS = 10;

    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public List<String> getNames() {
        return cards.stream()
                .map(Card::getName)
                .toList();
    }

    public String getFirstName() {
        return cards.getFirst().getName();
    }

    public int calculateValue() {
        int sum = cards.stream()
                .mapToInt(Card::getValue)
                .sum();

        return applyBestAceValue(sum);
    }

    private int applyBestAceValue(int sum) {
        if (hasAce() && (sum + ACE_BONUS) <= BLACKJACK_VALUE) {
            return sum + ACE_BONUS;
        }

        return sum;
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }
}
