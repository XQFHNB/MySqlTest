package com.xqf.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by XQF on 2016/12/2.
 */
public class UpdateRecord {
    private Connection connection;
    private PreparedStatement pstmt;
    private static final String sqlString = "update students set Sage=Sage+1";
//    private static final String sqlString = "update students set age=age+1";

    public int updateStudentDataInfo() {
        int count = -1;
        connection = new DBConnection().getConnection();
        try {
            pstmt = connection.prepareStatement(sqlString);
            count = pstmt.executeUpdate();
            connection.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("数据库读异常！"+e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        UpdateRecord updateRecord=new UpdateRecord();
        int count=updateRecord.updateStudentDataInfo();
        System.out.println(count);
    }
}
