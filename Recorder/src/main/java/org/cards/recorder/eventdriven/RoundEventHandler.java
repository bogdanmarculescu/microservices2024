package org.cards.recorder.eventdriven;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.recorder.service.RecorderServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoundEventHandler {

    private final RecorderServiceImpl recorderService;

    @RabbitListener(
            queues = "outcome.won"
    )
    void handleRoundEvent(
            String message
    ) {
        log.info("Got this from the Rabbit: " + message);
        //recorderService.addRoundForUser();
    }

}
