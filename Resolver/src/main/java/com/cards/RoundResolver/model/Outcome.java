package com.cards.RoundResolver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Outcome {
    private String outcomeText;

    @Id
    @Generated
    private Long outcomeId;
}
