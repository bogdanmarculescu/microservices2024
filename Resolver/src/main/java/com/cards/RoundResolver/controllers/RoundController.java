package com.cards.RoundResolver.controllers;

import com.cards.RoundResolver.model.Outcome;
import com.cards.RoundResolver.model.Round;
import com.cards.RoundResolver.services.LessSimpleRoundResolver;
import com.cards.RoundResolver.services.SimplestRoundResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
public class RoundController {

    //private final SimplestRoundResolver simplestRoundResolver;
    private final LessSimpleRoundResolver roundResolver;

    @GetMapping("/test")
    public Outcome resolveTest(){
        Round round = new Round();
        log.info("It's a test! Promise");
        return roundResolver.solve(round);
    }

    @PostMapping
    public Outcome resolve(@RequestBody Round round){
        log.info("It's a test 2! This time it's objects");

        return roundResolver.solve(round);
    }
}
