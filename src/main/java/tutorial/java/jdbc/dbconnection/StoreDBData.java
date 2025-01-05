package tutorial.java.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/establishing-jdbc-connection-in-java/?ref=next_article
 *
 * For storing data in database we will be using executeUpdate instead of executeQuery while executing the query
 * */
public class StoreDBData {

    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/gfg"; // table details
        String username = "root"; // MySQL credentials
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");

        // Entering the data
        Scanner k = new Scanner(System.in);
        System.out.print("enter name: ");
        String name = k.next();
        System.out.print("enter roll no: ");
        int roll = k.nextInt();
        System.out.print("enter class: ");
        String cls = k.next();

        // Inserting data using SQL query
        String sql = "insert into students values('" + roll + "','" + name + "','" + cls + "')";

        Statement st = con.createStatement();
        int m =  st.executeUpdate(sql); // Execute query
        if (m == 1)
            System.out.println("inserted successfully : " + sql);
        else
            System.out.println("insertion failed");

        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");
    }

}
