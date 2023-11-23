package database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;
import java.util.Arrays;

public class db {

    private static Connection conn;

    /**
     * Private function to establish a mariadb database connection based on .ENV credentials.
     */
    private static void create_conn(){
        try {
            Dotenv dotenv = null;
            dotenv = Dotenv.configure().load();


            String url = String.format("jdbc:mysql://%s:%s/%s",
                dotenv.get("DB_IP"),
                dotenv.get("DB_PORT"),
                dotenv.get("DB_NAME")
            );


            conn = DriverManager.getConnection( url , dotenv.get("DB_USER"), dotenv.get("DB_PASS"));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param Query
     * @param updateQuery
     * @return ResultSet
     *
     * Private execute functions which will be called by other
     * in-class methods to execute formed queries.
     */
    public static ResultSet execute(String Query, Boolean updateQuery){

        ResultSet out = null;
        create_conn();

        try {
            Statement statement = conn.createStatement();


            if (updateQuery){
                 statement.executeUpdate(Query);
            } else {
               out = statement.executeQuery(Query);
            }
        }

        catch (SQLException e) {
            System.out.println("SQl error:: " + e.getMessage());
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return out;
    }


    /**
     * @param email
     * @param password
     * @return boolean
     */
    public static ResultSet authenticate(String email, String password){

        String query = String.format("SELECT checkPassword('%s','%s')",
                email,
                password
            );

        ResultSet returnval = execute(query, false);


        return returnval;
    }
}
