package org.cards.cardserv.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.cardserv.model.Card;
import org.cards.cardserv.model.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card retrieveCard(Long cardId) {
        return cardRepository.findCardByCardId(cardId);
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }
}
