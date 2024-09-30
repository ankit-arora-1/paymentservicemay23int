package org.example.paymentservice.services.paymentgateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {
    private RazorpayGateway razorpayGateway;
    private StripeGateway stripeGateway;

    public PaymentGatewaySelector(
            RazorpayGateway razorpayGateway,
            StripeGateway stripeGateway
    ) {
        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;
    }

    public PaymentGateway get() {
        // Some logic to choose the correct payment gateway

        return stripeGateway;
    }

}
