package org.cards.cardserv.services;


import org.cards.cardserv.model.Card;

import java.util.List;

public interface CardService {

    Card retrieveCard(Long cardId);

    Card addCard(Card card);

    List<Card> getCards();

}
