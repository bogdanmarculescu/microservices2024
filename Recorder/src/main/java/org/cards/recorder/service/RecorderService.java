package org.cards.recorder.service;

import org.cards.recorder.model.RoundRecord;

import java.util.List;

public interface RecorderService {

    Long addRoundForUser(RoundRecord record);
    List<RoundRecord> getAllRounds();
}
