package com.mirror;

public class DBUtils {
    private static MyThreadLocal<Connection> myThreadLocal = new MyThreadLocal<Connection>();
    public static Connection getConnection(){
        Connection connection = myThreadLocal.get();
        if(connection == null){
            connection = new Connection();
            myThreadLocal.set(connection);
        }
        return connection;
    }
}
