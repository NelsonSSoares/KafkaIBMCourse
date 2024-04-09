package nelsonssoares.paymentservice.services.impl;

import lombok.extern.log4j.Log4j2;
import nelsonssoares.paymentservice.model.Payment;
import nelsonssoares.paymentservice.services.PaymentService;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL: PAGAMENTO RECEBIDO {} ", payment);
    }
}
