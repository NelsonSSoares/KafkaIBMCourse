package nelsonssoares.jsonconsumer.listener;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nelsonssoares.jsonconsumer.model.Payment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
        log.info("Payment received: " + payment.toString());
        Thread.sleep(2000);
        log.info("AntiFraud: analysing payment...");
        Thread.sleep(1000);
        log.info("AntiFraud: payment completed!");

        Thread.sleep(3000);

    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) throws InterruptedException {
        log.info("Generating PDF for payment: " + payment.getId());
        Thread.sleep(2000);

    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() throws InterruptedException {
        log.info("Email sent!");
        Thread.sleep(2000);

    }

}
