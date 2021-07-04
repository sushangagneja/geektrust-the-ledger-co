package repository;

import model.Loan;

import java.util.HashMap;
import java.util.Map;

public class LoanRepository {
    private final Map<String, Loan> loans;

    public LoanRepository() {
        this.loans = new HashMap<>();
    }

    public void addLoan(Loan loan) {
        loans.put(loan.getIdentifier(), loan);
    }

    public Map<String, Loan> getLoans() {
        return loans;
    }
}
