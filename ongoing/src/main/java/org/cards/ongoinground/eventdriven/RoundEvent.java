package org.cards.ongoinground.eventdriven;

import lombok.Value;

@Value
public class RoundEvent {
    Long playedCardId;
    Long roundId;

    Long outcomeId;
    String outcomeText;
    Long winningPlayerId;
}
