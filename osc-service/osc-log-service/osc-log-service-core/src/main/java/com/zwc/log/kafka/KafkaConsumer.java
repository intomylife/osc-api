package com.zwc.log.kafka;

import com.zwc.core.constants.KafkaConstants;
import com.zwc.log.service.VisitMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private VisitMongoDBService visitMongoDBService;

    /*
      * @ClassName KafkaConsumer
      * @Desc TODO  接收订阅者消息
      * @Date 2019/11/1 6:28 PM
      * @Version 1.0
     */
    @KafkaListener(topics = KafkaConstants.TO_VISIT , groupId = KafkaConstants.LOG_SERVICE_GROUP)
    public void receiveTopicMessage(String visitJson){
        // 收到消息
        System.out.println("KafkaConsumer ---> receiveTopicMessage：" + visitJson);
        // 收到的消息存入 MongoDB 中
        visitMongoDBService.insertVisitLog(visitJson);
    }

}
