package nelsonssoares.paymentservice.services;

import nelsonssoares.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
