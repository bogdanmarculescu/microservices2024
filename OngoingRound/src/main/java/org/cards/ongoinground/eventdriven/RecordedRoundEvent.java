package org.cards.ongoinground.eventdriven;


import lombok.Value;

@Value
public class RecordedRoundEvent {
    Long playedCardId;
    Long roundId;

    Long outcomeId;
    String outcomeText;
    Long winningPlayerId;
}
