package org.cards.ongoinground.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.clients.RecorderClient;
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
    private final RecorderClient recorderClient;

    @Override
    public OutcomeR completeRound(RoundR round) {
        log.info("Round: " + round.getPlayedCardId());
        log.warn("I'd like to call the other service here-ish");
        //OutcomeR o = new OutcomeR();

        OutcomeDTO o = roundClient.externalPostSolver(round);
        OutcomeR outcome = o.convertToOutcomeR();
        // record
        log.info("Record about to start");
        String rec = recorderClient.record(round, outcome);

        log.info("Record about to finish: " + rec);

        return outcome;
    }
}
