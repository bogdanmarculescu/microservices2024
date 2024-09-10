package org.cards.recorder.dtos;

import lombok.Getter;
import lombok.Setter;
import org.cards.recorder.model.RoundRecord;

@Setter
@Getter
public class RecorderDTO {
    private Long recordId;

    private Long playedCardId;
    private Long roundId;

    private Long outcomeId;
    private String outcomeText;
    private Long winningPlayerId;

    public RoundRecord toRoundRecord() {
        RoundRecord roundRecord = new RoundRecord();
        roundRecord.setPlayedCardId(playedCardId);
        roundRecord.setRoundId(roundId);

        roundRecord.setOutcomeId(outcomeId);
        roundRecord.setOutcomeText(outcomeText);
        roundRecord.setWinningPlayerId(winningPlayerId);
        return roundRecord;
    }
}
