package org.cards.recorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.recorder.model.RoundRecord;
import org.cards.recorder.model.RoundRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecorderServiceImpl implements RecorderService {

    private final RoundRecordRepository roundRecordRepository;

    @Override
    @Transactional
    public Long addRoundForUser(RoundRecord record) {
        log.info("Repo - adding record: "+ record);
        roundRecordRepository.save(record);
        return 1L;
    }

    @Override
    public List<RoundRecord> getAllRounds() {
        Iterable<RoundRecord> rounds = roundRecordRepository.findAll();
        List<RoundRecord> roundList = new ArrayList<>();
        while(rounds.iterator().hasNext()) {
            roundList.add(rounds.iterator().next());
        }
        return roundList;
    }

    public List<RoundRecord> getRoundsForUser(long userId) {
        List<RoundRecord> records = roundRecordRepository
                .findRoundRecordsByWinningPlayerId(userId)
                .stream().collect(Collectors.toList());

        return records;
    }
}
