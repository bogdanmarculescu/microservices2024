package org.cards.ongoinground.eventdriven;

import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RoundEventPublisher {
    private final AmqpTemplate amqpTemplate;
    private final String roundTopicExchange;

    public RoundEventPublisher(
            final AmqpTemplate amqpTemplate,
            @Value("${amqp.exchange.rounds}") final String roundTopicExchange
    ) {
        this.amqpTemplate = amqpTemplate;
        this.roundTopicExchange = roundTopicExchange;
    }

    public void publishRoundEvent(RoundR round, OutcomeR outcome){
        //build the event
        RecordedRoundEvent event = buildEvent(round, outcome);
        // figure out the routing key
        String routingKey = "round." + (event.getWinningPlayerId() == null ?
                "lost" : "won");
        // send the thingie
        amqpTemplate.convertAndSend(roundTopicExchange, routingKey, event);
    }

    public void publishRoundEventString(RoundR round, OutcomeR outcome){
        //build the event
        String event = buildEventString(round, outcome);
        // figure out the routing key
        String routingKey = "round.lost";
        // send the thingie
        amqpTemplate.convertAndSend(roundTopicExchange, routingKey, event);
    }

    public RecordedRoundEvent buildEvent(RoundR round, OutcomeR outcome) {
        RecordedRoundEvent event = new RecordedRoundEvent(
                round.getPlayedCardId(),
                round.getRoundId(),
                outcome.getOutcomeId(),
                outcome.getOutcomeText(),
                outcome.getWinningPlayerId()
        );
        return event;
    }
    public String buildEventString(RoundR round, OutcomeR outcome) {
        StringBuffer event = new StringBuffer();
        event.append("{")
                .append("\"playedCardId\":\"").append(round.getPlayerId()).append("\",")
                .append("\"roundId\":\"").append(round.getRoundId()).append("\",")
                .append("\"outcomeId\":\"").append(outcome.getOutcomeId()).append("\",")
                .append("\"outcomeText\":\"").append(outcome.getOutcomeText()).append("\",")
                .append("\"winningPlayerId\":\"").append(outcome.getWinningPlayerId()).append("\",")
                .append("}");

        return event.toString();
    }
}
