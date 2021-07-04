package model;

import java.util.Map;

public class Loan {
    private final String bankName;
    private final String borrowerName;
    private final double principal;
    private final int noOfYears;
    private final double rateOfInterest;

    public Loan(String bankName, String borrowerName, double principal, int noOfYears, double rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
    }

    public String getIdentifier() {
        return bankName + "-" + borrowerName;
    }

    public Balance getBalance(int emiNo, Map<Integer, Double> lumpSumPayments) {
        final int emiAmount = getEMIAmount();
        int totalPaymentMade = 0;
        for (int i = 1; i <= emiNo; i++) {
            totalPaymentMade += emiAmount;
            if (lumpSumPayments.containsKey(i)) {
                totalPaymentMade += lumpSumPayments.get(i);
            }
        }
        final double remainingAmount = getAmount() - totalPaymentMade;
        final int remainingEmi = (int) Math.ceil(remainingAmount/emiAmount);

        return new Balance(bankName, borrowerName, totalPaymentMade, remainingEmi);
    }

    private double getAmount() {
        final double interest = principal * noOfYears * rateOfInterest / 100;
        return principal + interest;
    }

    private int getEMIAmount() {
        return (int) Math.ceil(getAmount() / (noOfYears * 12));
    }
}
