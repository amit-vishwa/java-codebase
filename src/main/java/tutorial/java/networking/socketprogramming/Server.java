package tutorial.java.networking.socketprogramming;

import java.net.*;
import java.io.*;

/**
 * Refer: https://www.geeksforgeeks.org/socket-programming-in-java/?ref=lbp
 *
 * Socket programming in Java allows different programs to communicate with each other over a network, whether they are running on
 * the same machine or different ones. This article describes a very basic one-way Client and Server setup, where a Client
 * connects, sends messages to the server and the server shows them using a socket connection. There is a lot of low-level stuff
 * that needs to happen for these things to work but the Java API networking package (java.net) takes care of all of that, making
 * network programming very easy for programmers.
 * Note: A “socket” is an endpoint for sending and receiving data across a network.
 *
 * Server-Side Programming
 * 1. Establish a Socket Connection
 * To create a server application two sockets are needed.
 * ServerSocket: This socket waits for incoming client requests. It listens for connections on a specific port.
 * Socket: Once a connection is established, the server uses this socket to communicate with the client.
 * 2. Communication
 * Once the connection is established, you can send and receive data through the socket using streams.
 * The getOutputStream() method is used to send data to the client.
 * 3. Close the Connection
 * Once communication is finished, it’s important to close the socket and the input/output streams to free up resources.
 *
 * Explanation: In the above example, we have implemented a server that listens on a specific port, accepts a client connection, and reads messages sent by the client. The server displays the messages until “Over” is received, after which it closes the connection and terminates.
 *
 * Important Points:
 *
 * Server application makes a ServerSocket on a specific port which is 5000. This starts our Server listening for client requests coming in for port 5000.
 * Then Server makes a new Socket to communicate with the client: socket = server.accept()
 * The accept() method blocks(just sits there) until a client connects to the server.
 * Then we take input from the socket using getInputStream() method. Our Server keeps receiving messages until the Client sends “Over”.
 * After we’re done we close the connection by closing the socket and the input stream.
 * To run the Client and Server application on your machine, compile both of them. Then first run the server application and then run the Client application.
 * */
public class Server {

    // Initialize socket and input stream
    private Socket s = null;
    private ServerSocket ss = null;
    private DataInputStream in = null;

    // Constructor with port
    public Server(int port) {

        // Starts server and waits for a connection
        try
        {
            ss = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            s = ss.accept();
            System.out.println("Client accepted");

            // Takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(s.getInputStream()));

            String m = "";

            // Reads message from client until "Over" is sent
            while (!m.equals("Over"))
            {
                try
                {
                    m = in.readUTF();
                    System.out.println(m);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // Close connection
            s.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server s = new Server(5000);
    }
}
