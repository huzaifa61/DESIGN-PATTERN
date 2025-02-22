package creational.factory;

public class Bank {

    private static int balance = 100;


    private static synchronized int withdraw(int value) {
      if(balance-value>= 0){
          balance=balance-value;
          System.out.println("balance="+balance);
          return balance;
      }else{
          System.out.println("insufficient balance");
      }
        return balance;
    }

    private static class  withdrawTask implements Runnable {
        private int amount;

        withdrawTask(int value){
            amount=value;
        }
        @Override
        public void run() {
            withdraw(amount);
        }
    }


    public static void main(String[] args) {

        Thread person1 = new Thread(new withdrawTask(70),"thread1");
        Thread person2 = new Thread(new withdrawTask(70),"thread2");
        person1.start();
        person2.start();
    }


}
