package org.cards.recorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.recorder.dtos.OutcomeDTO;
import org.cards.recorder.dtos.RecorderDTO;
import org.cards.recorder.dtos.RoundDTO;
import org.cards.recorder.model.RoundRecord;
import org.cards.recorder.service.RecorderService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecorderController {

    private final RecorderService recorderService;

    @GetMapping
    public List<RoundRecord> getRecords(){
        return recorderService.getAllRounds();
    }

    @GetMapping("/id")
    public List<RoundRecord> getRecordsFromUser(Long playerId){
        return recorderService.getRoundsForUser(playerId);
    }


    @PostMapping
    public ResponseEntity<String> addRecord(
            @RequestBody RecorderDTO recordDTO){

        log.info("Adding record with post");

        RoundRecord record = recordDTO.toRoundRecord();

        Long added = recorderService.addRoundForUser(record);

        ResponseEntity<String> response = new ResponseEntity<>(
                "Recorded: " + added,
                HttpStatusCode.valueOf(200));

        return response;
    }
}
