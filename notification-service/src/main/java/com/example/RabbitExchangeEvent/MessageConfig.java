package com.example.RabbitExchangeEvent;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class MessageConfig {

    public static final String QUEUE_NOTIFICATION = "notification_queue";

    public static final String EXCHANGE_NOTIFICATION = "notification_exchange";

    public static final String ROUTING_KEY_NOTIFICATION = "notification_routingKey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NOTIFICATION);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NOTIFICATION);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_NOTIFICATION);
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
