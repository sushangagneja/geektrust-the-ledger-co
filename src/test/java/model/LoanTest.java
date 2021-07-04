package model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanTest {
    private final String bankName = "DBI";
    private final String borrowerName = "Sushan";
    private final Loan loan = new Loan(bankName, borrowerName, 100.0, 2, 5.0);

    @Test
    void shouldReturnUniqueIdentifier() {
        assertEquals("DBI-Sushan", loan.getIdentifier());
    }

    @Test
    void shouldGetBalanceWhenThereAreNoLumpSumPaymentsTillTheRequestedEMINo() {
        final Balance balance = loan.getBalance(5, new HashMap<Integer, Double>() {{
            put(6, 10.0);
        }});

        final Balance expectedBalance = new Balance(bankName, borrowerName, 25, 17);
        assertEquals(expectedBalance, balance);
    }

    @Test
    void shouldGetBalanceWhenThereAreLumpSumPaymentsBeforeTheRequestedEMINo() {
        final Balance balance = loan.getBalance(7, new HashMap<Integer, Double>() {{
            put(6, 10.0);
        }});

        final Balance expectedBalance = new Balance(bankName, borrowerName, 45, 13);
        assertEquals(expectedBalance, balance);
    }
}