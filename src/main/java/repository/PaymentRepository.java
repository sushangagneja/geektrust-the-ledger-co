package repository;

import model.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private final Map<String, Map<Integer, Double>> payments;

    public PaymentRepository() {
        this.payments = new HashMap<>();
    }

    public void addLumpSumPayment(Payment payment) {
        if(!payments.containsKey(payment.getIdentifier())) {
            payments.put(payment.getIdentifier(), new HashMap<>());
        }

        Map<Integer, Double> loanPayments = payments.get(payment.getIdentifier());
        loanPayments.put(payment.getMadeAfterEMINumber(), payment.getLumpSumAmount());
    }

    public Map<String, Map<Integer, Double>> getPayments() {
        return payments;
    }
}
