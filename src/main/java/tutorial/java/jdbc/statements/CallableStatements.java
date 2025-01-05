package tutorial.java.jdbc.statements;

import java.sql.*;

/**
 * Refer: https://www.geeksforgeeks.org/types-of-statements-in-jdbc/?ref=next_article
 *
 * 3. Callable Statement
 * A CallableStatement is used to execute stored procedures in the database. Stored procedures are precompiled SQL statements that can be called with parameters. They are useful for executing complex operations that involve multiple SQL statements.
 * Syntax:
 * CallableStatement cstmt = con.prepareCall(“{call ProcedureName(?, ?)}”);
 * {call ProcedureName(?, ?)}: Calls a stored procedure named ProcedureName with placeholders ? for input parameters.
 *
 * Methods to Execute:
 * execute(): Executes the stored procedure and returns a boolean indicating whether the result is a ResultSet (true) or an update count (false).
 * executeQuery(): Executes a stored procedure that returns a ResultSet.
 * executeUpdate(): Executes a stored procedure that performs an update and returns the number of rows affected.
 *
 * Explanation:
 * This Java code demonstrates how to use a CallableStatement in JDBC to execute a stored procedure.
 * It connects to a MySQL database and prepares a CallableStatement to call a stored procedure named peopleinfo with two parameters.
 * After executing the procedure, it runs a SELECT query to retrieve and display all records from the people table.
 * Exception handling is included to manage potential SQL and class loading errors.
 * */
public class CallableStatements {

    public static void main(String[] args) {
        try {

            String url = "jdbc:mysql://localhost:3306/gfg"; // table details
            String username = "root"; // MySQL credentials
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");

            // Create a CallableStatement
            CallableStatement cs =
                    con.prepareCall("{call get_students()}");
            // Execute the stored procedure
            ResultSet res = cs.executeQuery();

            // Process the results
            while (res.next()) {
                System.out.println("Name: " + res.getString("name") +
                        ", RollNo: " + res.getInt("rollno"));
            }

            // Close resources
            res.close();
            cs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
