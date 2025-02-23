package LLDPaymentGateway.transaction;

import java.util.List;

public class TransactionController {

    TransactionService transactionService ;
    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    public TransactionDo makePayment(TransactionDo transactionDo){
        return transactionService.makePayment(transactionDo);
    }

    public List<Transaction> getTransactionHistory(int userId){
        return transactionService.getTransactionHistory(userId);

    }
}
