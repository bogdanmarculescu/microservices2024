package org.cards.ongoinground.dtos;

import lombok.Getter;
import lombok.Setter;
import org.cards.ongoinground.model.OutcomeR;

@Getter
@Setter
public class OutcomeDTO {
    private String outcomeText;
    private Long outcomeId;
    private Long winningPlayerId;

    public OutcomeR convertToOutcomeR(){
        OutcomeR outcomeR = new OutcomeR();
        outcomeR.setOutcomeText(this.outcomeText);
        outcomeR.setWinningPlayerId(this.winningPlayerId);
        outcomeR.setOutcomeId(this.outcomeId);
        return outcomeR;
    }
}
