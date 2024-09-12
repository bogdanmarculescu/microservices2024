package org.cards.recorder.configuration;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class AMQPConfiguration {

    // exchanges
    @Bean
    public TopicExchange roundTopicExchange(
            @Value("${amqp.exchange.name}") final String exchangeName
    ){
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    // bindings
    @Bean
    public Binding roundLostBinding(
          final Queue roundQueue,
          final TopicExchange roundTopicExchange
    ){
        return BindingBuilder
                .bind(roundQueue)
                .to(roundTopicExchange)
                .with("round.won");
    }

    // queues
    @Bean
    public Queue roundQueue(
            @Value("${amqp.queue.name}") final String queueName
    ){
        return QueueBuilder
                .durable(queueName)
                .build();
    }


    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();

        final MappingJackson2MessageConverter jsonConverter =
                new MappingJackson2MessageConverter();
        jsonConverter.getObjectMapper().registerModule(
                new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));

        factory.setMessageConverter(jsonConverter);
        return factory;
    }

    @Bean
    public RabbitListenerConfigurer rabbitListenerConfigurer(
            final MessageHandlerMethodFactory messageHandlerMethodFactory) {
        return (c) -> c.setMessageHandlerMethodFactory(messageHandlerMethodFactory);
    }

}
