package com.notes.notesreaderauth.payment;

import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway {

    @Override
    public String getGatewayName() {
        return "razorpay";
    }

    @Override
    public boolean verifyPayment(String paymentId) {
        // POC: pretend Razorpay verification succeeded
        System.out.println("Verifying Razorpay payment: " + paymentId);
        return true;
    }
}