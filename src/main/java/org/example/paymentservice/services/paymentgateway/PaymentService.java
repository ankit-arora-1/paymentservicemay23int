package org.example.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewaySelector paymentGatewaySelector;

    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    public String initiatePayment() {
        return paymentGatewaySelector
                .get()
                .generatePaymentLink();
    }
}
