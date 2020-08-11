package com.study.boot.kafka;

import com.alibaba.fastjson.JSON;
import com.study.boot.bean.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KafkaProduct {

    Logger logger = LogManager.getLogger(KafkaProduct.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendSyn(City city){
        kafkaTemplate.send("ticket_refund_info", JSON.toJSONString(city));
    }

    @Async
    public void sendAsync(String message,String topic){
        logger.info(message);
        kafkaTemplate.send(topic, message);
    }

}
