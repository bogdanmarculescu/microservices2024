package com.cards.RoundResolver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DiceRoll {
    Random rand = new Random();

    public int roll(int minValue, int maxValue, int multiplier) {
        return (rand.nextInt(maxValue) + minValue) * multiplier;
    }
}
