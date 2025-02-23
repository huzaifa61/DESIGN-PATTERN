package LLDChainResponsibility;

public class Main {

    public static void main(String[] args) {

        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR,"Exception Happens");
         logProcessor.log(LogProcessor.ERROR,"Error is there");

        logProcessor.log(LogProcessor.DEBUG,"DEBUG Happens");
        logProcessor.log(LogProcessor.INFO,"Info Happens");

    }
}
