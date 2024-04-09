package nelsonssoares.paymentservice.resource.impl;

import lombok.RequiredArgsConstructor;
import nelsonssoares.paymentservice.model.Payment;
import nelsonssoares.paymentservice.resource.PaymentResource;
import nelsonssoares.paymentservice.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> createPayment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
