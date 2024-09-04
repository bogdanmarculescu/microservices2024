package com.cards.RoundResolver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Round {

    @Id
    @Generated
    private Long roundId;

    private int playedCardId;
}
