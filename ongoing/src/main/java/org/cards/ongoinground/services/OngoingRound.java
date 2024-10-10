package org.cards.ongoinground.services;

import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;

public interface OngoingRound {
    OutcomeR completeRound(RoundR round);
}
