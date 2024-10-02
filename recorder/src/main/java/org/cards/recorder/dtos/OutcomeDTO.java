package org.cards.recorder.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutcomeDTO {
    private Long outcomeId;
    private String outcomeText;
    private Long winningPlayerId;
}
