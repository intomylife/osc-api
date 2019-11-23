package com.zwc.base.kafka;

import com.zwc.core.constants.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName KafkaConsumer
 * @Desc TODO   Kafka 消费者
 * @Date 2019/11/1 6:27 PM
 * @Version 1.0
 */
@Service
public class KafkaConsumer {

    /*
      * @ClassName KafkaConsumer
      * @Desc TODO  接收订阅者消息
      * @Date 2019/11/1 6:28 PM
      * @Version 1.0
     */
    @KafkaListener(topics = KafkaConstants.TO_VISIT , groupId = KafkaConstants.BASE_SERVICE_GROUP)
    public void receiveTopicMessage(String message){
        System.out.println("KafkaConsumer ---> receiveTopicMessage：" + message);
    }

}
