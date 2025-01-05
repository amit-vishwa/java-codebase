package tutorial.java.jdbc.statements;

import java.sql.*;

/**
 * Refer: https://www.geeksforgeeks.org/types-of-statements-in-jdbc/?ref=next_article
 *
 * 2. Prepared Statement
 * A PreparedStatement represents a precompiled SQL statement that can be executed multiple times. It accepts parameterized SQL queries, with ? as placeholders for parameters, which can be set dynamically.
 *
 * Illustration:
 * Considering in the people database if there is a need to INSERT some values, SQL statements such as these are used:
 *
 * INSERT INTO people VALUES (“Ayan”,25);
 *
 *
 * INSERT INTO people VALUES(“Kriya”,32);
 *
 *
 * To do the same in Java, one may use Prepared Statements and set the values in the ? holders, setABC() of a prepared statement is used as shown:
 *
 * String query = “INSERT INTO people(name, age)VALUES(?, ?)”;
 *
 *
 * PreparedStatement pstmt = con.prepareStatement(query);
 *
 *
 *  // where pstmt is an object name
 *
 *
 * pstmt.setString(1,”Ayan”);
 *
 *
 * ptstmt.setInt(2,25);
 *
 *
 * Implementation: Once the PreparedStatement object is created, there are three ways to execute it:
 *
 * execute(): This returns a boolean value and executes a static SQL statement that is present in the prepared statement object.
 * executeQuery(): This returns a ResultSet from the current prepared statement.
 * executeUpdate(): This returns the number of rows affected by the DML statements such as INSERT, DELETE, and more that is present in the current Prepared Statement.
 * */
public class PreparedStatements {

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
            String sql = "SELECT * FROM students WHERE rollno = ?";
            int rollno = 2;
            // Using Prepared statement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rollno);
            ResultSet rs = ps.executeQuery();

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
