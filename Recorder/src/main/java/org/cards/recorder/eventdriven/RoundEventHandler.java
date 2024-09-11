package org.cards.recorder.eventdriven;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.recorder.model.RoundRecord;
import org.cards.recorder.service.RecorderServiceImpl;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoundEventHandler {

    private final RecorderServiceImpl recorderService;

    @RabbitListener(queues = "record.queue")
    void handleRoundEvent(final RoundRecord record){
        log.info("Message received: {}", record);

        try {
            recorderService.addRoundForUser(record);
        }
        catch (final Exception e) {
            log.error("Error processing round. " + e.getMessage());
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }

}
