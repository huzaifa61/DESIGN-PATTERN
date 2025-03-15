import java.util.concurrent.*;

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 1000; i++) {
                queue.put(i);  // Blocks if queue is full
                System.out.println("Produced: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                int data = queue.take();  // Blocks if queue is empty
                System.out.println("Consumed: " + data);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

