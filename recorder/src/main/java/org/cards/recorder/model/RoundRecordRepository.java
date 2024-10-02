package org.cards.recorder.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoundRecordRepository extends CrudRepository<RoundRecord, Long> {

    /**
     * Retrieves all RoundRecord objects won by a particular player.
     *
     * @param winningPlayerId the id of the player in question
     * @return the list of RoundRecord objects.
     */
    List<RoundRecord> findRoundRecordsByWinningPlayerId(Long winningPlayerId);

}
