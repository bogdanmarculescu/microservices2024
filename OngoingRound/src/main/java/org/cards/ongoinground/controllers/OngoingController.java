package org.cards.ongoinground.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.cards.ongoinground.services.OngoingRoundExampleImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ongoing")
public class OngoingController {

    private final OngoingRoundExampleImpl ongoingRound;

    @GetMapping
    public OutcomeR communicationSolution(){
        RoundR roundR = new RoundR();
        roundR.setPlayerId(13L);
        roundR.setRoundId(42L);
        roundR.setPlayedCardId(1L);

        OutcomeR or = ongoingRound.completeRound(roundR);
        return or;
    }
}
