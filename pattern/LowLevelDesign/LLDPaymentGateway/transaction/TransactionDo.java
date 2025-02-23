package LLDPaymentGateway.transaction;


import lombok.Data;

@Data
public class TransactionDo {

    int transactionId;
    int senderId;
    int receiverId;
    int debitAmount;
    int creditAmount;
    int status;
    TransactionStatus transactionStatus;
}
