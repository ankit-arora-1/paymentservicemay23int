package org.example.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeWebhook {

    @PostMapping("/stripeWebhook")
    public void webhook(@RequestBody Object o) {
        System.out.println("DEBUG");
    }

}
