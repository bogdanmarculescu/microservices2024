package org.cards.cardserv.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Card {

    @Id
    private Long cardId;

    private String cardText;
    private Long cardValue;
}
