package service;

import model.Balance;
import model.Loan;
import model.Payment;
import repository.LoanRepository;
import repository.PaymentRepository;
import request.BalanceRequest;

import java.util.Map;

public class LoanService {
    private final LoanRepository loanRepository;
    private final PaymentRepository paymentRepository;

    public LoanService(LoanRepository loanRepository, PaymentRepository paymentRepository) {
        this.loanRepository = loanRepository;
        this.paymentRepository = paymentRepository;
    }

    public Balance getBalance(BalanceRequest balanceRequest) {
        final String identifier = balanceRequest.getIdentifier();
        final Loan loan = loanRepository.getLoans().get(identifier);
        final Map<Integer, Double> loanPayments = paymentRepository.getPayments().get(identifier);

        return loan.getBalance(balanceRequest.getEmiNo(), loanPayments);
    }

    public void addLoan(Loan loan) {
        loanRepository.addLoan(loan);
    }

    public void addPayment(Payment payment) {
        paymentRepository.addLumpSumPayment(payment);
    }
}
