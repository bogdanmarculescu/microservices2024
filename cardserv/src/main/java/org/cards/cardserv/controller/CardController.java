package org.cards.cardserv.controller;


import lombok.RequiredArgsConstructor;
import org.cards.cardserv.model.Card;
import org.cards.cardserv.services.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cardapi")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/cards")
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        return cardService.retrieveCard(id);
    }

}
