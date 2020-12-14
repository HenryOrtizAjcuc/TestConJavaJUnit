package org.example.javatest.payment;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
