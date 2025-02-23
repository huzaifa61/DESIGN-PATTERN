package LLDChainResponsibility;

public class InfoLogProcessor extends LogProcessor{

    public void log(int level,String message){
        if(level==INFO){
            System.out.println(INFO+" "+message);
        }else{
            super.log(level,message);
        }
    }
    InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }
}
