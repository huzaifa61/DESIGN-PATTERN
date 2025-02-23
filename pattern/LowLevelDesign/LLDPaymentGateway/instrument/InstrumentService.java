package LLDPaymentGateway.instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {

   static Map<Integer, List<Instrument>> userVsInstruments = new HashMap<>();
   public abstract InstrumentDo addInstrument(InstrumentDo instrument);
   public abstract List<InstrumentDo> getInstrumentsByUserId(int userId);
}
