package com.cards.RoundResolver.services;

import com.cards.RoundResolver.model.Outcome;
import com.cards.RoundResolver.model.Round;
import org.springframework.stereotype.Service;

@Service
public class SimplestRoundResolver implements RoundResolver {
    @Override
    public Outcome solve(Round round) {
        Outcome outcome = new Outcome();
        outcome.setOutcomeText("it's just a test");
        return outcome;
    }
}
