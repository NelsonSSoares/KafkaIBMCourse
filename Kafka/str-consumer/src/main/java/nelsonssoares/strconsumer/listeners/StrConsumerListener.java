package nelsonssoares.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import nelsonssoares.strconsumer.custom.StrConsumerCustomListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {


    //ANOTACAO CUSTOMIZADA PARA SIMPLIFICAR A CRIACAO DE LISTENERS
   @StrConsumerCustomListener(groupId = "1")
    public void create(String message) {
        log.info("CREATE: Message received: " + message);
    }
   @StrConsumerCustomListener(groupId = "1")
    public void log(String message) {
        log.info("LOG: Message received: " + message);
    }

    @StrConsumerCustomListener(groupId = "2")
    public void history(String message) {
        log.info("History: Message received: " + message);
    }






    /*
       LISTENERS COM O MESMO GRUPO CONSOMEM PARTIÇÕES DIFERENTES,
         LOGO, CADA MENSAGEM É CONSUMIDA POR UM ÚNICO LISTENER,
         DESDE QUE O TOPICO SEJA O MESMO.
     */

    /*
        É POSSIVEL DEFINIR A PARTIÇÃO QUE O LISTENER IRÁ CONSUMIR,
        ATRAVÉS DO ATRIBUTO "topicPartitions" DO ANNOTATION @KafkaListener.
        EXEMPLO:
        @KafkaListener(groupId = "1",
        topicPartitions ={
         @TopicPartition(topic = "str-topic", partitions = {"0"})
         }
         , containerFactory = "strContainerFactory")
     */
//    @KafkaListener(groupId = "1", topics = "str-topic", containerFactory = "strContainerFactory")
//    public void create(String message) {
//       log.info("CREATE: Message received: " + message);
//    }
//    // listerners abaixo sao de teste
//    @KafkaListener(groupId = "1", topics = "str-topic", containerFactory = "strContainerFactory")
//    public void log(String message) {
//        log.info("LOG: Message received: " + message);
//    }
//
//    @KafkaListener(groupId = "2", topics = "str-topic", containerFactory = "strContainerFactory")
//    public void history(String message) {
//        log.info("History: Message received: " + message);
//    }
//    //DEFININDO QUAL PARTICAO SERA LIDA DO TOPICO "str-topic"
//    @KafkaListener(groupId = "2",
//            topicPartitions = {
//                @TopicPartition(topic = "str-topic", partitions = {"1"})
//            }
//            , containerFactory = "strContainerFactory")
//    public void testPartition(String message) {
//        log.info("TESTE PARTITION 0: Message received: " + message);
//    }
}
