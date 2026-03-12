package com.notes.notesreaderauth.payment;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String getGatewayName() {
        return "stripe";
    }

    @Override
    public boolean verifyPayment(String paymentId) {
        // POC: pretend Stripe verification succeeded
        System.out.println("Verifying Stripe payment: " + paymentId);
        return true;
    }
}