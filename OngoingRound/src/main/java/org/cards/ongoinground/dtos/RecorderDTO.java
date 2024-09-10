package org.cards.ongoinground.dtos;

import lombok.Getter;
import lombok.Setter;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;

@Setter
@Getter
public class RecorderDTO {
    private Long recordId;

    private Long playedCardId;
    private Long roundId;

    private Long outcomeId;
    private String outcomeText;
    private Long winningPlayerId;

    public RecorderDTO(RoundR round, OutcomeR outcome) {
        this.playedCardId = round.getPlayedCardId();
        this.roundId = round.getRoundId();

        this.outcomeId = outcome.getOutcomeId();
        this.outcomeText = outcome.getOutcomeText();
        this.winningPlayerId = outcome.getWinningPlayerId();
    }
}
