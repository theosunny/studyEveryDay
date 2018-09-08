package concurrent.art.chapter4.simpleConnectDemo;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void relaseConnection(Connection conn) {
        if (conn != null) {
            synchronized (pool) {
                //连接释放后需要进行通知，这样其他消费者就知道连接池已经归还了一个连接
                pool.addLast(conn);
                pool.notifyAll();
            }
        }

    }

    public Connection fetchConnection(long mills) throws Exception {
        synchronized (pool) {
            //完全超时
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }

        }
    }
}
