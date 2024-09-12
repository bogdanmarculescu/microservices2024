package org.cards.ongoinground.eventdriven;


import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoundEventPublisher {

    // config amqp stuff
    // what exchange am I publishing to

    private final AmqpTemplate amqpTemplate;
    private final String exchangeName;

    public RoundEventPublisher(
            final AmqpTemplate amqpTemplate,
            @Value("${amqp.exchange.name}") final String exchangeName
    ) {
        this.amqpTemplate = amqpTemplate;
        this.exchangeName = exchangeName;
    }

    public void publishRoundEventString(
            RoundR round,
            OutcomeR outcome
    ){
        // build the message/event
        String event = buildEventString(round, outcome);

        // decide on routing
        String routingKey = "round." +
                (outcome.getWinningPlayerId() == null ?
                        "lost" : "won");

        // send the thing
        log.info("Here's the Rabbit message: {}", event);
        amqpTemplate.convertAndSend(exchangeName, routingKey, event);
    }

    public void publishRoundEvent(
            RoundR round,
            OutcomeR outcome
    ){
        RoundEvent event = buildEvent(round, outcome);
        String routingKey = "round." +
                (event.getWinningPlayerId() == null ?
                        "lost" : "won");
        log.info("Here's the Rabbit message (as object): {}", event);
        amqpTemplate.convertAndSend(exchangeName, routingKey, event);

    }

    public String buildEventString(RoundR round, OutcomeR outcome){
        StringBuffer eventBuffer = new StringBuffer();

        eventBuffer.append("{")
                .append("\"playedCardId\":" + round.getPlayedCardId() + ",")
                .append("\"roundId\":" + round.getRoundId() + ",")
                .append("\"outcomeId\":" + outcome.getOutcomeId() + ",")
                .append("\"outcomeText\":" + outcome.getOutcomeText() + ",")
                .append("\"winningPlayerId\":" + outcome.getWinningPlayerId())
                .append("}");
        return eventBuffer.toString();
    }

    public RoundEvent buildEvent(RoundR round, OutcomeR outcome){
        RoundEvent event = new RoundEvent(
                round.getPlayedCardId(),
                round.getRoundId(),
                outcome.getOutcomeId(),
                outcome.getOutcomeText(),
                outcome.getWinningPlayerId()
        );
        return event;
    }
}
