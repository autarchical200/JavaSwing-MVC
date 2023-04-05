/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static Connection conn = null;

    public Connect() throws SQLException, Exception {
        getConnection();
    }

    public static Connection getConnection() throws Exception {

        String userName = "sa";
        String passWord = "123";
        String URL = "jdbc:sqlserver://HungPhan:1433;databaseName=qlpizza;user=sa;password=123;encrypt=false";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(URL, userName, passWord);
        return conn;
    }
}




