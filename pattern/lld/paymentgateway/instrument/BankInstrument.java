package paymentgateway.instrument;

import lombok.Data;

@Data
public class BankInstrument extends Instrument {
    String bankName;
    String ifscCode;
    InstrumentType instrumentType;
    String accountNumber;
}
