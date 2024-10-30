package com.cards.RoundResolver.services;

import com.cards.RoundResolver.model.DiceRoll;
import com.cards.RoundResolver.model.Outcome;
import com.cards.RoundResolver.model.Round;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LessSimpleRoundResolver implements RoundResolver {


    @Override
    public Outcome solve(Round round) {
        DiceRoll diceRoll = new DiceRoll();
        int dieRoll = diceRoll.roll(1,6,1);
        log.info("Random number: " + dieRoll);

        return solve(round, dieRoll);
    }

    public Outcome solve(Round round, int dieRoll){
        Long cardId = round.getPlayedCardId();

        Outcome outcome = new Outcome();
        outcome.setOutcomeText("You played: " + cardId + "; I had a die roll: " + dieRoll);
        outcome.setOutcomeId(42L);

        outcome.setWinningPlayerId(round.getPlayerId());

        return outcome;
    }
}
