package com.xqf.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by XQF on 2016/12/1.
 */
public class CreateTable {
    Connection connection;
    private Statement stmt;
    public static final String CREATE_TABLE = "create table students(" +
            "Sno char(10)," +
            "Sname char(20)," +
            "Sage int," +
            "Smajor char(10))";

    public boolean createStudentTable() {
        connection = new DBConnection().getConnection();
        boolean returnResult = true;
        try {
            stmt = connection.createStatement();
            returnResult = stmt.execute(CREATE_TABLE);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("数据库读异常！");
            returnResult = false;
        }
        return returnResult;
    }

    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        boolean isCreateSuccess = createTable.createStudentTable();
        if (isCreateSuccess) {
            System.out.println("创建表成功");
        } else {
            System.out.println("创建表不成功");
        }
    }
}
