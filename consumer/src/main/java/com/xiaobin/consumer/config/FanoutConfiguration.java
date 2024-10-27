package com.xiaobin.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joy
 * @date: 2024/10/27 18:03
 * @description: Fanout交换机配置
 * Good Luck!!!
 */

@Configuration
public class FanoutConfiguration {

    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("hmall.fanout2").build();
    }

    @Bean
    public Queue fanoutQueue3() {
//        return QueueBuilder.durable("fanout.queue3");
        return new Queue("fanout.queue3");
    }

    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }

    @Bean
    public Queue fanoutQueue4() {
//        return QueueBuilder.durable("fanout.queue3");
        return new Queue("fanout.queue4");
    }

    @Bean
    public Binding fanoutBinding4() {
        return BindingBuilder.bind(fanoutQueue4()).to(fanoutExchange());
    }
}
