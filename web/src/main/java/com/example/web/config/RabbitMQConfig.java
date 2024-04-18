package com.example.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final String queue;

    private final String exchange;

    private final String routingKey;

    public RabbitMQConfig(
            @Value("${rabbitmq.queue}") String queue,
            @Value("${rabbitmq.exchange}") String exchange,
            @Value("${rabbitmq.routingKey}") String routingKey) {
        this.queue = queue;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    @Bean
    public Queue queue() {
        return new Queue(queue, false);
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange(exchange, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey).noargs();
    }

    @Bean
    public MessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
