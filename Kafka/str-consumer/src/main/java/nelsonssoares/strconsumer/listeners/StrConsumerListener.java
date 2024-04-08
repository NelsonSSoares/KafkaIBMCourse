package nelsonssoares.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "0", topics = "str-topic", containerFactory = "strContainerFactory")
    public void create(String message) {
       log.info("CREATE: Message received: " + message);
    }
    // listerners abaixo sao de teste
    @KafkaListener(groupId = "1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info("LOG: Message received: " + message);
    }

    @KafkaListener(groupId = "2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message) {
        log.info("History: Message received: " + message);
    }
}
