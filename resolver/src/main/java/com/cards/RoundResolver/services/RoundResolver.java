package com.cards.RoundResolver.services;

import com.cards.RoundResolver.model.Outcome;
import com.cards.RoundResolver.model.Round;

public interface RoundResolver {
    Outcome solve(Round round);
}
