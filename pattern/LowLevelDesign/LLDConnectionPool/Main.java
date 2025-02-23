package LLDConnectionPool;

public class Main {

    public static void main(String[] args) {

//        ConnectionPool<DBConnection> dbpool = new GenericConnectionPool<>(10,DBConnection::new);
//
//        DBConnection conn = dbpool.getConnection();
//        conn.connect();

        // Create a thread pool of size 5
        ConnectionPool<WorkerThread> threadPool = new GenericConnectionPool<>(5, WorkerThread::new);

        // Borrow a thread from the pool
        WorkerThread worker = threadPool.getConnection();
        // Start the worker, etc.
        // When done, release it back
        threadPool.releaseConnection(worker);

    }


}
