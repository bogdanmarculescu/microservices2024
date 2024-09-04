package org.cards.ongoinground.dtos;

import lombok.Getter;
import lombok.Setter;
import org.cards.ongoinground.model.OutcomeR;

@Getter
@Setter
public class OutcomeDTO {
    private String receivedText;

    public OutcomeR convertToOutcomeR(){
        OutcomeR outcomeR = new OutcomeR();
        outcomeR.setOutcomeText(this.receivedText);
        return outcomeR;
    }
}
