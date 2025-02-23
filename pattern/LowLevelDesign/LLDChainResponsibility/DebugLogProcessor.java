package LLDChainResponsibility;

public class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int level, String message) {
        if(level==DEBUG){
            System.out.println(DEBUG+" "+message);
        }else{
            super.log(level, message);
        }
    }
}
