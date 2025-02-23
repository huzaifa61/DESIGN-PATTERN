package LLDPaymentGateway.instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService {


    @Override
    public InstrumentDo addInstrument(InstrumentDo instrument) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentId = new Random().nextInt(10+100)+10;
        bankInstrument.accountNumber = instrument.getAccountNumber();
        bankInstrument.instrumentType = InstrumentType.BANK;
        bankInstrument.ifscCode = instrument.getIfscCode();
        bankInstrument.userId = instrument.getUserId();
        List<Instrument> instrumentDoList = userVsInstruments.get(bankInstrument.userId);
        if(instrumentDoList == null) {
            instrumentDoList = new ArrayList<Instrument>();
            userVsInstruments.put(bankInstrument.userId, instrumentDoList);
        }
        instrumentDoList.add(bankInstrument);
        return mapInstrumentDotoInstrument(bankInstrument);
    }

    private InstrumentDo mapInstrumentDotoInstrument(BankInstrument bankInstrument) {
        InstrumentDo instrumentDo = new InstrumentDo();
        instrumentDo.instrumentId = bankInstrument.instrumentId;
        instrumentDo.accountNumber = bankInstrument.accountNumber;
        instrumentDo.instrumentType = InstrumentType.BANK;
        instrumentDo.ifscCode = bankInstrument.ifscCode;
        instrumentDo.userId = bankInstrument.userId;
        return instrumentDo;
    }

    @Override
    public List<InstrumentDo> getInstrumentsByUserId(int userId) {
        List<Instrument> instrumentList=  userVsInstruments.get(userId);
       List<InstrumentDo> userInstrumentFetched = new ArrayList<>();
       for(Instrument instrument : instrumentList) {
           if(instrument.getUserId() == userId) {
               userInstrumentFetched.add(mapInstrumentDotoInstrument((BankInstrument) instrument));
           }
       }

       return userInstrumentFetched;

    }
}
