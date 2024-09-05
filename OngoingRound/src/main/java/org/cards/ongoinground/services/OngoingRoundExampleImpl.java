package org.cards.ongoinground.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.clients.RoundClient;
import org.cards.ongoinground.dtos.OutcomeDTO;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OngoingRoundExampleImpl implements OngoingRound{

    private final RoundClient roundClient;

    @Override
    public OutcomeR completeRound(RoundR round) {
        log.info("Round: " + round.playedCardId);
        log.warn("I'd like to call the other service here-ish");

        //OutcomeDTO o = roundClient.externalResolve();
        OutcomeDTO o = roundClient.externalPostSolver();

        return o.getLocalOutcome();
    }
}
