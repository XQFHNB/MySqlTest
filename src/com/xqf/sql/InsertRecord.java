package com.xqf.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by XQF on 2016/12/1.
 */
public class InsertRecord {
    private static final String INSERT_DATA = "insert into students values('130063','xqf',20,'CS')";
    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt;

    public boolean addStudentDataInfo() {
        connection = new DBConnection().getConnection();
        boolean insertResult = true;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(INSERT_DATA);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("数据库读异常！");
            insertResult = false;
        }
        return insertResult;
    }

    public int addStudentDataInfo(String Sno, String Sname, int Sage, String Smajor) {
        int count = 0;
        boolean insertResult = true;
        connection = new DBConnection().getConnection();
        String insertSqlString = "insert into students values(?,?,?,?)";

        try {
            pstmt = connection.prepareStatement(insertSqlString);
            pstmt.setString(1, Sno);
            pstmt.setString(2, Sname);
            pstmt.setInt(3, Sage);
            pstmt.setString(4, Smajor);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("数据库读异常！");
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("在关闭数据的时候遇到异常，异常信息为" + e.getMessage());
            }

        }
        return count;
    }

    public static void main(String[] args) {
        InsertRecord insertRecord = new InsertRecord();
        boolean isInsertSucesss = insertRecord.addStudentDataInfo();
        if (isInsertSucesss) {
            System.out.println("数据添加成功");
        } else {
            System.out.println("数据添加不成功");
        }
        int count = insertRecord.addStudentDataInfo("9527", "wly", 20, "CS");
        int count1 = insertRecord.addStudentDataInfo("9527", "wly", 20, "CS");

        System.out.println(count + "条记录被添加");
        System.out.println(count1 + "条记录被添加");

    }
}
