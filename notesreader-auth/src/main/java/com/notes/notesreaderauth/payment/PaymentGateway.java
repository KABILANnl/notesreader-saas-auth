package com.notes.notesreaderauth.payment;

public interface PaymentGateway {

    String getGatewayName();

    boolean verifyPayment(String paymentId);
}