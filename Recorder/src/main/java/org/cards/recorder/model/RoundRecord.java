package org.cards.recorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoundRecord {

    @Id
    @GeneratedValue
    private Long recordId;

    private Long playedCardId;
    private Long roundId;

    private Long outcomeId;
    private String outcomeText;
    private Long winningPlayerId;
}
