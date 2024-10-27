package com.xiaobin.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Joy
 * @date: 2024/10/27 15:47
 * @description: 消息监听者
 * Good Luck!!!
 */

@Slf4j
@Component
public class MqListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg) {
        log.error("消费者收到了simple.queue的消息:{}", msg);
    }

    @RabbitListener(queues = "work.queue")
    public void listenSimpleQueue1(String msg) throws InterruptedException {
        log.info("消费者1 收到了work.queue的消息:{}", msg);
        TimeUnit.MICROSECONDS.sleep(20);
    }

    @RabbitListener(queues = "work.queue")
    public void listenSimpleQueue2(String msg) throws InterruptedException {
        log.warn("消费者2 收到了work.queue的消息:{}", msg);
        TimeUnit.MICROSECONDS.sleep(200);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) {
        log.info("消费者1 收到了fanout.queue1的消息:{}", msg);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) {
        log.warn("消费者2 收到了fanout.queue2的消息:{}", msg);
    }

    @RabbitListener(queues = "direct.queue1")
    public void listenDirectQueue1(String msg) {
        log.info("消费者1 收到了direct.queue1的消息:{}", msg);
    }

    @RabbitListener(queues = "direct.queue2")
    public void listenDirectQueue2(String msg) {
        log.warn("消费者2 收到了direct.queue2的消息:{}", msg);
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg) {
        log.info("消费者1 收到了topic.queue1的消息:{}", msg);
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg) {
        log.warn("消费者2 收到了topic.queue2的消息:{}", msg);
    }
}
