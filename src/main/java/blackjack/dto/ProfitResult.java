package blackjack.dto;

import blackjack.domain.betting.Bettings;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import java.util.LinkedHashMap;
import java.util.Map;

public record ProfitResult(
        Map<String, Integer> profitResult
) {

    public static ProfitResult from(Players players, Bettings bettings) {
        Map<String, Integer> profitResult = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            int bettingAmount = (int) bettings.calculateProfit(player);
            profitResult.put(player.getName(), bettingAmount);
        }
        return new ProfitResult(profitResult);
    }

    public int calculateProfitOfDealer() {
        return profitResult.values().stream()
                .mapToInt(Integer::intValue)
                .sum() * (-1);
    }

}
