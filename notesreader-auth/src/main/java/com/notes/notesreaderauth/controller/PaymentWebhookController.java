package com.notes.notesreaderauth.controller;

import com.notes.notesreaderauth.payment.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentWebhookController {

    private final PaymentService paymentService;

    public PaymentWebhookController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //@PostMapping("/webhook") this is what secure for stripe,payments
    @GetMapping("/webhook") //but using get for local checking
    public String handleWebhook(
            @RequestParam String gateway,
            @RequestParam String paymentId,
            @RequestParam String email) {

        boolean success = paymentService.handlePaymentSuccess(gateway, paymentId, email);

        if (success) {
            return "Payment successful. User whitelisted.";
        }

        return "Payment verification failed.";
    }
}