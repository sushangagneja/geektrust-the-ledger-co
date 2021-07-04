package model;

import java.util.Objects;

public class Balance {
    private final String bankName;
    private final String borrowerName;
    private final int totalPaymentMade;
    private final int emisRemaining;

    public Balance(String bankName, String borrowerName, int totalPaymentMade, int emisRemaining) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.totalPaymentMade = totalPaymentMade;
        this.emisRemaining = emisRemaining;
    }

    @Override
    public String toString() {
        return bankName + " " + borrowerName + " " + totalPaymentMade + " " + emisRemaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return totalPaymentMade == balance.totalPaymentMade && emisRemaining == balance.emisRemaining && Objects.equals(bankName, balance.bankName) && Objects.equals(borrowerName, balance.borrowerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, borrowerName, totalPaymentMade, emisRemaining);
    }
}
