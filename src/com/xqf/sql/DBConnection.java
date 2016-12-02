package com.xqf.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by XQF on 2016/12/1.
 */
public class DBConnection {
    String dbDriver = "com.mysql.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost:3306/first_db?useSSL=false";
    String userName = "root";
    String userPassword = "125880";
    Connection connection;
//

    /**
     * 在构造方法中就把事情办了，当然上面的这些字段也可以写作为方法里的临时变量，但是我认为还是放在类中的字段比较好，方便复用嘛，
     * 不过说复用好像也没有复用到哪里，因为Connection是通过静态方法来获取的。也就是说创建connection的过程中一定要有方法的调用，
     * 尽管可能是构造方法.当然写成名字比较好认的方法也是比较舒适
     */
    public DBConnection() {
        try {
            Class.forName(dbDriver);
            System.out.println("Driver success!! ");
            connection = DriverManager.getConnection(dbUrl, userName, userPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver failure!");
        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("close database success!");
            } catch (SQLException e) {
                System.out.println("close failure!!");
            }
        }
    }

    public static void main(String[] args) {
        DBConnection myDBConnection = new DBConnection();
        myDBConnection.closeConnection();
    }
}
