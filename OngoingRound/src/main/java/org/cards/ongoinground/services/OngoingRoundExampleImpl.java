package org.cards.ongoinground.services;

import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OngoingRoundExampleImpl implements OngoingRound{
    @Override
    public OutcomeR completeRound(RoundR round) {
        log.info("Round: " + round.playedCardId);
        log.warn("I'd like to call the other service here-ish");
        OutcomeR o = new OutcomeR();
        return o;
    }
}
