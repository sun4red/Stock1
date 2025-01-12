package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

// 어려워서 사용 보류
public class DBConnectionPool {

    private String url;
    private String user;
    private String password;
    private Queue<Connection> connectionPool;

    private final int maxSize = 5;

    private static DBConnectionPool pool = null;

    private DBConnectionPool(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = new LinkedList<>();
        initializeConnectionPool();
    }

    public static synchronized DBConnectionPool getInstance(String url, String user, String password) {
        if (pool == null) {
            pool = new DBConnectionPool(url, user, password);
        }
        return pool;
    }

    private void initializeConnectionPool() {
        try {
            for (int i = 0; i < maxSize; i++) {
                connectionPool.add(createConnection());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public synchronized Connection getConnection(long timeout) throws SQLException, InterruptedException {
        long startTime = System.currentTimeMillis(); // 메소드 실행 시간 기록

        while (connectionPool.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " 커넥션 풀 반납 대기");
            long elapsedTime = System.currentTimeMillis() - startTime; // 메소드 경과 시간 계산
            long waitTime = timeout - elapsedTime; // 제한시간 - 경과 시간
            System.out.println(Thread.currentThread().getName() + " 메소드 경과 시간: " + elapsedTime);

            if (waitTime <= 0) {
                System.out.println(Thread.currentThread().getName() + " 타임아웃");
                throw new SQLException("Timeout waiting for connection");
            }

            // 연결반환 대기
            // wait()메소드는 다른 스레드가 notify()로 호출하거나 waitTime 시간동안 대기

            wait(waitTime); // wait()로 수행하면 무한대기상태가 될수있음

        }

        Connection connection = connectionPool.poll();
        System.out.println(Thread.currentThread().getName() + " 커넥션 풀 획득");

        int remainConnection = getAvailableConnectionsCount();
        System.out.println("스레드 대여 현재 개수 : " + remainConnection);

        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.offer(connection);
        int remainConnection = getAvailableConnectionsCount();
        System.out.println(Thread.currentThread().getName() + " 커넥션 풀 반납");
        System.out.println("스레드 반납 현재 개수 : " + remainConnection);
        notify();
    }

    public synchronized void closePool() throws SQLException {
        for (Connection connection : connectionPool) {
            connection.close();
        }
        System.out.println("DBCP Close");
        connectionPool.clear();
    }

    public synchronized int getAvailableConnectionsCount() {
        return connectionPool.size();
    }

}