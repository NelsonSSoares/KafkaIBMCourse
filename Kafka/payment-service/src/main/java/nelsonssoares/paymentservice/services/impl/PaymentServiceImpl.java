package nelsonssoares.paymentservice.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nelsonssoares.paymentservice.model.Payment;
import nelsonssoares.paymentservice.services.PaymentService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    public void sendPayment(Payment payment) throws InterruptedException {
        log.info("PAGAMENTO RECEBIDO: {} ", payment);

        Thread.sleep(1000); // para esperar 1 segundo

        log.info("PAGAMENTO PROCESSADO: {} ", payment);

        kafkaTemplate.send("payment-topic", payment);

    }
}
