package org.example.paymentservice.services.paymentgateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StripeGateway implements PaymentGateway {

    private String apiKey = "sk_test_51OmDwvSCqKXtl1vtFyhMdLSiVy1lq5lnlACuPwolNZZY1OvCB4gmVSxS715hF5LHmdAATeIQ8SrCYUp96vxblWqi007Y3tepkk";

    @Override
    public String generatePaymentLink() {
        try {
            Stripe.apiKey = this.apiKey;

            Price price = getPrice();

            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            ).setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                    .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                    .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                            .setUrl("https://google.com?ref_id=" + "1234").build()).build())
                            .build();
            PaymentLink paymentLink = PaymentLink.create(params);
            return paymentLink.getUrl();
        }catch (StripeException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private Price getPrice() {
        try {
            PriceCreateParams params =
                    PriceCreateParams.builder()
                            .setCurrency("inr")
                            .setUnitAmount(1000L)
//                            .setRecurring(
//                                    PriceCreateParams.Recurring.builder()
//                                            .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
//                                            .build()
//
//                            )
                            .setProductData(
                                    PriceCreateParams
                                            .ProductData
                                            .builder()
                                            .setName("PS5")
                                            .build()
                            )
                            .build();
            Price price = Price.create(params);
            return price;
        }catch (StripeException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
