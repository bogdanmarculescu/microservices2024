package org.cards.ongoinground.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoundDTO {
    private Long playedCardId;
    private Long roundId;
    private Long playerId;
}
