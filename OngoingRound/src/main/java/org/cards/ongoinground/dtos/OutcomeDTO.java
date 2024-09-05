package org.cards.ongoinground.dtos;

import lombok.Getter;
import lombok.Setter;
import org.cards.ongoinground.model.OutcomeR;

@Getter
@Setter
public class OutcomeDTO {

    private Long outcomeId;
    private String outcomeText;

    public OutcomeR getLocalOutcome(){
        OutcomeR outcome = new OutcomeR();
        outcome.setOutcomeText(this.outcomeText);

        return outcome;
    }
}
