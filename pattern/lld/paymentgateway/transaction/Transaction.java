package paymentgateway.transaction;


import lombok.Data;

@Data
public class Transaction {
    int transactionId;
    int senderId;
    int receiverId;
    int debitAmount;
    int creditAmount;
    String status;
    int amount;
    TransactionStatus transactionStatus;
}
