package org.example.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class RazorpayGateway implements PaymentGateway {
    @Override
    public String generatePaymentLink() {
        return null;
    }

}
