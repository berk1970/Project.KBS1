package database;

import java.sql.*;
import java.util.*;

public class SQLCon {
    private Connection connection;
    private static String databaseName = "sakila", username = "root", password = "";

    public SQLCon() {
        String url = "jdbc:mysql://localhost/" + databaseName;
        try {
            this.connection = DriverManager.getConnection( url,username,password );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
