package paymentgateway.instrument;

import java.util.ArrayList;
import java.util.List;

public class CardService extends InstrumentService {
    @Override
    public InstrumentDo addInstrument(InstrumentDo instrument) {

        CardInstrument cardInstrument= new CardInstrument();
        cardInstrument.cardNumber = instrument.getCardNumber();
        cardInstrument.instrumentId = instrument.getInstrumentId();
        cardInstrument.instrumentType = InstrumentType.CARD;
        cardInstrument.cvv = instrument.cvv;
        cardInstrument.userId = instrument.userId;

        return mapInstrumenttoDo(cardInstrument);
    }

    @Override
    public List<InstrumentDo> getInstrumentsByUserId(int userId) {
        List<Instrument> mapToInstrument =   userVsInstruments.get(userId);
        List<InstrumentDo> instruments = new ArrayList<InstrumentDo>();

        for (Instrument instrument : mapToInstrument) {
            if(instrument.userId == userId){
                instruments.add(mapInstrumenttoDo((CardInstrument) instrument));
            }
        }
        return instruments;
    }

    public InstrumentDo mapInstrumenttoDo(CardInstrument instrument){
        InstrumentDo  instrumentDo = new InstrumentDo();
        instrumentDo.setCardNumber(instrument.cardNumber);
        instrumentDo.setCvv(instrument.cvv);
        instrumentDo.setUserId(instrument.userId);
        instrumentDo.setInstrumentId(instrument.instrumentId);
        instrumentDo.setInstrumentType(instrument.instrumentType);
        return instrumentDo;
    }
}
