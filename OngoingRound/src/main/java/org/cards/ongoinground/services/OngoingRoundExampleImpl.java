package org.cards.ongoinground.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.clients.RoundResolverClient;
import org.cards.ongoinground.dtos.OutcomeDTO;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OngoingRoundExampleImpl implements OngoingRound{

    private final RoundResolverClient roundResolverClient;

    @Override
    public OutcomeR completeRound(RoundR round) {
        log.info("Round: " + round.playedCardId);
        log.warn("I'd like to call the other service here-ish");
        //OutcomeR o = new OutcomeR();

        OutcomeDTO o = roundResolverClient.remoteSolve(round);

        return o.convertToOutcomeR();
    }
}
