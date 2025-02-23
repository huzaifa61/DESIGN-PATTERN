package connectionPool;

public interface ConnectionPool<T> {


    T getConnection();


    void releaseConnection(T connection);


    int getAvailableCount();
}

