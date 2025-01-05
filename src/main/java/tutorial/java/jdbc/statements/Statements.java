package tutorial.java.jdbc.statements;

import java.sql.*;

/**
 * Refer: https://www.geeksforgeeks.org/types-of-statements-in-jdbc/?ref=next_article
 *
 * 1. Statement
 * A Statement object is used for general-purpose access to databases and is useful for executing static SQL statements at runtime.
 * Syntax:
 * Statement statement = connection.createStatement();
 *
 * Implementation: Once the Statement object is created, there are three ways to execute it.
 * - execute(String SQL): It is used to executes any SQL statements (like SELECT, INSERT, UPDATE or DELETE). If the ResultSet
 * object is retrieved, then it returns true else false is returned.
 * - executeUpdate(String SQL): It is used to executes SQL statements (like INSERT, UPDATE or DELETE). It returns the number of
 * rows affected by the SQL statement.
 * - ResultSet executeQuery(String SQL): It is used to executes the SELECT query. It returns a ResultSet object that contains the
 * data retrieved by the query.
 * */
public class Statements {

    public static void main(String[] args) {
        try {

            String url = "jdbc:mysql://localhost:3306/gfg"; // table details
            String username = "root"; // MySQL credentials
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");

            // Create a statement
            Statement st = con.createStatement();
            // Execute a query
            String sql = "SELECT * FROM students";
            ResultSet rs = st.executeQuery(sql);

            // Process the results
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", RollNo: " + rs.getInt("rollno"));
            }

            // Close resources
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
