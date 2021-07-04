package repository;

import model.Loan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanRepositoryTest {
    private final Loan loan = new Loan("DBI", "Sushan", 100.0, 2, 5.0);
    private final LoanRepository loanRepository = new LoanRepository();

    @Test
    void shouldAddLoan() {
        loanRepository.addLoan(loan);

        assertEquals(loan, loanRepository.getLoans().get(loan.getIdentifier()));
    }
}