package org.cards.cardserv.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {

    Card findCardByCardId(Long cardId);
    List<Card> findAll();
    //Long save(Card card);
}
