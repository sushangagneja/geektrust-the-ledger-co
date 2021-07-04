package repository;

import model.Payment;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentRepositoryTest {
    private final Payment payment = new Payment("DBI", "Sushan", 5.0, 2);
    private final PaymentRepository paymentRepository = new PaymentRepository();

    @Test
    void shouldAddPayment() {
        paymentRepository.addLumpSumPayment(payment);

        final HashMap expectedLoanPayments = new HashMap<Integer, Double>() {{
            put(2, 5.0);
        }};
        assertEquals(expectedLoanPayments, paymentRepository.getPayments().get(payment.getIdentifier()));
    }
}