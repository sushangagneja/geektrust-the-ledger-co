package model;

public class Payment {
    private final String bankName;
    private final String borrowerName;
    private final double lumpSumAmount;
    private final int madeAfterEMINumber;

    public Payment(String bankName, String borrowerName, double lumpSumAmount, int madeAfterEMINumber) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSumAmount = lumpSumAmount;
        this.madeAfterEMINumber = madeAfterEMINumber;
    }

    public String getIdentifier() {
        return bankName + "-" + borrowerName;
    }

    public double getLumpSumAmount() {
        return lumpSumAmount;
    }

    public int getMadeAfterEMINumber() {
        return madeAfterEMINumber;
    }
}
