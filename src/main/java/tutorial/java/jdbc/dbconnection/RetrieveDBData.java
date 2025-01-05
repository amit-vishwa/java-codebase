package tutorial.java.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Refer: https://www.geeksforgeeks.org/establishing-jdbc-connection-in-java/?ref=next_article
 *
 * Before Establishing JDBC Connection in Java (the front end i.e your Java Program and the back end i.e the database) we should
 * learn what precisely a JDBC is and why it came into existence. Now let us discuss what exactly JDBC stands for and will ease
 * out with the help of real-life illustration to get it working.
 *
 * What is JDBC?
 * JDBC is an acronym for Java Database Connectivity. It’s an advancement for ODBC ( Open Database Connectivity ). JDBC is a
 * standard API specification developed in order to move data from the front end to the back end. This API consists of classes and
 * interfaces written in Java. It basically acts as an interface (not the one we use in Java) or channel between your Java
 * program and databases i.e it establishes a link between the two so that a programmer can send data from Java code and store it
 * in the database for future use.
 *
 * Steps to Connect Java Application with Database
 * Below are the steps that explains how to connect to Database in Java:
 * Step 1 – Import the Packages
 * Step 2 – Load the drivers using the forName() method
 * Step 3 – Register the drivers using DriverManager
 * Step 4 – Establish a connection using the Connection class object
 * Step 5 – Create a statement
 * Step 6 – Execute the query
 * Step 7 – Close the connections
 * */
public class RetrieveDBData {

    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/gfg"; // table details
        String username = "root"; // MySQL credentials
        String password = "root";
        String query = "select * from students"; // query to be run
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); // Execute query
        rs.next();
        String roll = rs.getString("rollno");
        String name = rs.getString("name");
        String clas = rs.getString("class"); // Retrieve name from db

        System.out.println("RollNo: " + roll + " | Name: " + name + " | Class: " + clas); // Print result on console
        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");
    }

}
