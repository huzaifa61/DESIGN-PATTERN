package paymentgateway.instrument;

import java.util.List;

public class InstrumentController {
    InstrumentFactory instrumentFactory;

    public InstrumentController() {
        this.instrumentFactory = instrumentFactory;
    }

    public InstrumentDo addInstrument(InstrumentDo instrument) {
        InstrumentService instrumentService = instrumentFactory.getInstrument(instrument.getInstrumentType());
       return instrumentService.addInstrument(instrument);
    }

    public List<InstrumentDo> getAllInstrument(int userId) {
        InstrumentService bankInstrumentController= instrumentFactory.getInstrument(InstrumentType.BANK);
        InstrumentService cardInstrumentController= instrumentFactory.getInstrument(InstrumentType.CARD);

        List<InstrumentDo> instrumentDoList = bankInstrumentController.getInstrumentsByUserId(userId);
        instrumentDoList.addAll(cardInstrumentController.getInstrumentsByUserId(userId));
        return instrumentDoList;


    }

    public InstrumentDo getInstrumentById(int instrumentId, int userId) {
        List<InstrumentDo> allInstrument = getAllInstrument(userId);

        for(InstrumentDo instrument: allInstrument) {
        if(instrument.getInstrumentId() == instrumentId) {
        return instrument;}
        }

        return null;
    }


}
