package model.application;

import db.DB;
import db.DbException;

import java.sql.*;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            while(rs.next())System.out.println(rs.getInt("Id") + ", " + rs.getString("Name") );

        } catch (SQLException e) {throw new DbException(e.getMessage());
        } finally {

            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
