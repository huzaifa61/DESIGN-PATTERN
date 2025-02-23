package LLDConnectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

public class GenericConnectionPool<T> implements ConnectionPool<T> {

    private final BlockingQueue<T> pool;
    private final Supplier<T> creator;

    public GenericConnectionPool(int size, Supplier<T> creator) {
        this.pool = new ArrayBlockingQueue<>(size);
        this.creator = creator;
        // Pre-populate the pool
        for (int i = 0; i < size; i++) {
            pool.add(creator.get());
        }
    }

    @Override
    public T getConnection() {
        try {
            // Blocks until a connection is available
            return pool.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for a connection", e);
        }
    }

    @Override
    public void releaseConnection(T connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }

    @Override
    public int getAvailableCount() {
        return pool.size();
    }
}
