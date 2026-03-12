package com.notes.notesreaderauth.payment;

import org.springframework.stereotype.Service;
import com.notes.notesreaderauth.entity.PaidUser;
import com.notes.notesreaderauth.repository.PaidUserRepository;

import java.util.List;

@Service
public class PaymentService {

    private final List<PaymentGateway> gateways;
    private final PaidUserRepository paidUserRepository;

    public PaymentService(List<PaymentGateway> gateways, PaidUserRepository paidUserRepository) {
        this.gateways = gateways;
        this.paidUserRepository = paidUserRepository;
    }

    public boolean handlePaymentSuccess(String gatewayName, String paymentId, String email) {

        PaymentGateway gateway = gateways.stream()
                .filter(g -> g.getGatewayName().equalsIgnoreCase(gatewayName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported payment gateway"));

        boolean verified = gateway.verifyPayment(paymentId);

        if (verified) {
            if (!paidUserRepository.existsByEmail(email)) {

                PaidUser paidUser = new PaidUser(email, paymentId, gatewayName);

                paidUserRepository.save(paidUser);

                System.out.println("User added to whitelist DB: " + email);
            }
        }

        return verified;
    }
}