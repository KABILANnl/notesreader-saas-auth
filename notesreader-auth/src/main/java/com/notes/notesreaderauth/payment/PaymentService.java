package com.notes.notesreaderauth.payment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final List<PaymentGateway> gateways;

    public PaymentService(List<PaymentGateway> gateways) {
        this.gateways = gateways;
    }

    public boolean handlePaymentSuccess(String gatewayName, String paymentId, String email) {

        PaymentGateway gateway = gateways.stream()
                .filter(g -> g.getGatewayName().equalsIgnoreCase(gatewayName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported payment gateway"));

        boolean verified = gateway.verifyPayment(paymentId);

        if (verified) {
            // POC logic
            System.out.println("Payment verified. Whitelisting user: " + email);
        }

        return verified;
    }
}