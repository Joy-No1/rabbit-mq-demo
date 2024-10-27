package com.xiaobin.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = PublisherApplication.class)
class PublisherApplicationTests {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        String queueName = "simple.queue";
        String message = "你好啊 玢玢";
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    void testWorkQueue() throws InterruptedException {
        String queueName = "work.queue";
        for (int i = 1; i <= 50; i++) {
            String message = "你好啊 玢玢___" + i;
            rabbitTemplate.convertAndSend(queueName, message);
            TimeUnit.MICROSECONDS.sleep(20);
        }
    }

    @Test
    void testSendFanout() {
        String exchangeName = "hmall.fanout";
        String message = "你好啊 !!!!";
        rabbitTemplate.convertAndSend(exchangeName, null, message);
    }

    @Test
    void testSendDirect() {
        String exchangeName = "hmall.direct";
        String msg1 = "红色";
        String msg2 = "蓝色";
        String msg3 = "黄色";
        rabbitTemplate.convertAndSend(exchangeName, "red", msg1);
        rabbitTemplate.convertAndSend(exchangeName, "blue", msg2);
        rabbitTemplate.convertAndSend(exchangeName, "yellow", msg3);
    }

    @Test
    void testSendTopic() {
        String exchangeName = "hmall.topic";
        String message1 = "日本的新闻";
        String message2 = "中国的美女";
        String message3 = "中国的新闻";
        rabbitTemplate.convertAndSend(exchangeName, "Japan.news", message1);
        rabbitTemplate.convertAndSend(exchangeName, "China.Girl", message2);
        rabbitTemplate.convertAndSend(exchangeName, "China.news", message3);
    }

}
