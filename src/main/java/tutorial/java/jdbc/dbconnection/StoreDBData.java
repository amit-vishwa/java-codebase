package tutorial.java.jdbc.dbconnection;

import tutorial.java.jdbc.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/establishing-jdbc-connection-in-java/?ref=next_article
 *
 * For storing data in database we will be using executeUpdate instead of executeQuery while executing the query
 * */
public class StoreDBData {

    public static void main(String[] args) throws Exception
    {
        String url = DatabaseConfig.url();
        String username = DatabaseConfig.username();
        String password = DatabaseConfig.password();
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
        String sql = "insert into students values (?, ?, ?)";

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, roll);
        st.setString(2, name);
        st.setString(3, cls);
        int m = st.executeUpdate();
        if (m == 1)
            System.out.println("inserted successfully");
        else
            System.out.println("insertion failed");

        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");
    }

}
