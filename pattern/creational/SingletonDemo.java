package creational;

public class SingletonDemo {
    public static void main(String args[]) {
        LoggingSystem l = LoggingSystem.getLoggingSystem();
        l.logValues("huz is mad");
    }
}

class LoggingSystem {

    private static LoggingSystem loggingSystem;

    private LoggingSystem() {
    }

    public static LoggingSystem getLoggingSystem() {
        if (loggingSystem == null) {
            synchronized (LoggingSystem.class) {
                if (loggingSystem == null) {
                    loggingSystem = new LoggingSystem();
                }
            }
        }
        return loggingSystem;
    }

    public void logValues(String msg) {
        System.out.println(msg);

    }

}