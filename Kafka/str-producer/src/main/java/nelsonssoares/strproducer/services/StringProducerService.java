package nelsonssoares.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
@Log4j2
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendStringMessage( String message) {
      CompletableFuture<SendResult<String,String>> future = kafkaTemplate.send("str-topic", message);

      future.whenComplete((result, ex) -> {
          if (ex == null) {
              log.info("Message sent successfully: {}", result);
          } else {
              log.error("Error sending message: {}", ex.getMessage());
          }

          log.info("Partition: {}, Offset {}", result.getRecordMetadata().partition(),
          result.getRecordMetadata().offset());
      });



    }
}
