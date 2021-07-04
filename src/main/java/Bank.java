import model.Balance;
import model.Loan;
import model.Payment;
import repository.LoanRepository;
import repository.PaymentRepository;
import request.BalanceRequest;
import request.RequestType;
import service.LoanService;

public class Bank {
    private final LoanService loanService;

    public Bank() {
        this.loanService = new LoanService(new LoanRepository(), new PaymentRepository());
    }

    public void handle(String request) {
        final String[] requestDetails = request.split(" ");
        RequestType requestType = RequestType.valueOf(requestDetails[0]);

        switch (requestType) {
            case BALANCE:
                handleBalanceRequest(requestDetails);
                break;
            case LOAN:
                handleLoanRequest(requestDetails);
                break;
            case PAYMENT:
                handlePaymentRequest(requestDetails);
                break;
            default:
                System.out.println("Invalid operation encountered");
        }
    }

    private void handlePaymentRequest(String[] requestDetails) {
        String bankName = requestDetails[1];
        String borrowerName = requestDetails[2];
        Double lumpSumAmount = Double.parseDouble(requestDetails[3]);
        Integer madeAfterEMINumber = Integer.parseInt(requestDetails[4]);

        loanService.addPayment(new Payment(bankName, borrowerName, lumpSumAmount, madeAfterEMINumber));
    }

    private void handleLoanRequest(String[] requestDetails) {
        String bankName = requestDetails[1];
        String borrowerName = requestDetails[2];
        Double principal = Double.parseDouble(requestDetails[3]);
        Integer noOfYears = Integer.parseInt(requestDetails[4]);
        Double rateOfInterest = Double.parseDouble(requestDetails[5]);

        loanService.addLoan(new Loan(bankName, borrowerName, principal, noOfYears, rateOfInterest));
    }

    private void handleBalanceRequest(String[] requestDetails) {
        String bankName = requestDetails[1];
        String borrowerName = requestDetails[2];
        Integer emiNo = Integer.parseInt(requestDetails[3]);

        final Balance balance = loanService.getBalance(new BalanceRequest(bankName, borrowerName, emiNo));
        System.out.println(balance);
    }
}

