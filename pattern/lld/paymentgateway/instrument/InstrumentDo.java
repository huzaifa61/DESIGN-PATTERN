package paymentgateway.instrument;

import lombok.Data;

@Data
public class InstrumentDo {
    int instrumentId;
    int userId;
    InstrumentType instrumentType;
    String accountNumber;
    String ifscCode;
    String cvv;
    String cardNumber;


}
