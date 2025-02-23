package LLDPaymentGateway.instrument;

public class InstrumentFactory {
    public static InstrumentService getInstrument(InstrumentType instrumentType) {
        if (instrumentType == InstrumentType.BANK) {
            return new BankService();
        }else if(instrumentType == InstrumentType.CARD){
            return new CardService();
        }
        return null;

    }
}
