package com.xqf.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by XQF on 2016/12/2.
 */
public class QueryStudent {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet resultSet;


    public void getOneStudentInfo(String Sno) {
        connection = new DBConnection().getConnection();
        String sqlString = "select * from students where Sno=?";
        try {
            pstmt = connection.prepareStatement(sqlString);
            pstmt.setString(1, Sno);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
            }
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("数据库读错误" + e.getMessage());
        }

    }

    public void getAllStudentsInfo() {
        connection = new DBConnection().getConnection();
        String sqlString = "select * from students";
        try {
            pstmt = connection.prepareStatement(sqlString);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
            }
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("数据库读错误" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        QueryStudent queryStudent = new QueryStudent();
        queryStudent.getOneStudentInfo("130063");
        System.out.println("-------------------------------------------------------------");
        queryStudent.getAllStudentsInfo();
    }
}
