package paymentgateway.instrument;

import lombok.Data;

@Data
public class Instrument {
    int instrumentId;
    int userId;
    InstrumentType instrumentType;

}
