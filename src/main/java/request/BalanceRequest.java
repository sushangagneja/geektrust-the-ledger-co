package request;

public class BalanceRequest {
    private final String bankName;
    private final String borrowerName;
    private final int emiNo;

    public BalanceRequest(String bankName, String borrowerName, int emiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiNo = emiNo;
    }

    public String getIdentifier() {
        return bankName + "-" + borrowerName;
    }

    public int getEmiNo() {
        return emiNo;
    }
}
