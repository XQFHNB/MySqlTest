package com.xqf.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by XQF on 2016/12/2.
 */

public class DeleteRecord {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private static final String sqlString = "delete from students where Sno=?";

    public int deleteOneStudent(String Sno) {
        int count = -1;
        connection = new DBConnection().getConnection();
        try {
            pstmt = connection.prepareStatement(sqlString);
            pstmt.setString(1, Sno);
            count = pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        DeleteRecord deleteRecord = new DeleteRecord();
        int count = deleteRecord.deleteOneStudent("9527");
        System.out.println(count);
    }
}
