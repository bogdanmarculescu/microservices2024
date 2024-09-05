package com.cards.RoundResolver.services;

import com.cards.RoundResolver.model.Outcome;
import com.cards.RoundResolver.model.Round;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class LessSimpleRoundResolver implements RoundResolver {

    Random rand = new Random();

    @Override
    public Outcome solve(Round round) {
        int dieRoll = rand.nextInt(6) + 1;
        log.info("Random number: " + dieRoll);

        return solve(round, dieRoll);
    }

    public Outcome solve(Round round, int dieRoll){
        return new Outcome("I had a die roll" + dieRoll, 42L);
    }
}
