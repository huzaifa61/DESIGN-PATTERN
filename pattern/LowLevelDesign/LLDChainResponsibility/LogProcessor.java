package LLDChainResponsibility;


public abstract class LogProcessor {

    public static int INFO =1;
    public static int DEBUG =2;
    public static int ERROR =3;

    LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor logProcessor){
        this.nextLogProcessor = logProcessor;
    }

    public void  log(int level,String msg){
        if(nextLogProcessor != null){
            nextLogProcessor.log(level,msg);
        }
    }
}
