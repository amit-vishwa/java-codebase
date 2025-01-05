package tutorial.java.networking.socketprogramming;

import java.io.*;
import java.net.*;

/**
 * Refer: https://www.geeksforgeeks.org/java-networking/?ref=lbp
 *
 * Java Socket programming is practiced for communication between the applications working on different JRE. Sockets implement the
 * communication tool between two computers using TCP. Java Socket programming can either be connection-oriented or connection-less.
 * In Socket Programming, Socket and ServerSocket classes are managed for connection-oriented socket programming. However,
 * DatagramSocket and DatagramPacket classes are utilized for connection-less socket programming.
 * A client application generates a socket on its end of the communication and strives to combine that socket with a server. When
 * the connection is established, the server generates an object of socket class on its communication end. The client and the
 * server can now communicate by writing to and reading from the socket.
 * The java.net.Socket class describes a socket, and the java.net.ServerSocket class implements a tool for the server program to
 * host clients and build connections with them.
 *
 * Steps to establishing a TCP connection between two computing devices using Socket Programming
 * The following are the steps that occur on establishing a TCP connection between two computers using socket programming are
 * given as follows:
 * Step 1 – The server instantiates a ServerSocket object, indicating at which port number communication will occur.
 * Step 2 – After instantiating the ServerSocket object, the server requests the accept() method of the ServerSocket class. This
 * program pauses until a client connects to the server on the given port.
 * Step 3 – After the server is idling, a client instantiates an object of Socket class, defining the server name and the port
 * number to connect to.
 * Step 4 – After the above step, the constructor of the Socket class strives to connect the client to the designated server and
 * the port number. If communication is authenticated, the client forthwith has a Socket object proficient in interacting with
 * the server.
 * Step 5 – On the server-side, the accept() method returns a reference to a new socket on the server connected to the client’s
 * socket.
 * After the connections are stabilized, communication can happen using I/O streams. Each object of a socket class has both an
 * OutputStream and an InputStream. The client’s OutputStream is correlated to the server’s InputStream, and the client’s
 * InputStream is combined with the server’s OutputStream. Transmission Control Protocol (TCP) is a two-way communication
 * protocol. Hence information can be transmitted over both streams at the corresponding time.
 *
 * Client-Side Programming
 * 1. Establish a Socket Connection
 * To connect to another machine we need a socket connection. A socket connection means both machines know each other’s IP
 * address and TCP port. The java.net.Socket class is used to create a socket.
 * Socket socket = new Socket(“127.0.0.1”, 5000)
 * The first argument: The IP address of Server i.e. 127.0.0.1  is the IP address of localhost, where code will run on the single
 * stand-alone machine.
 * The second argument: The TCP Port number (Just a number representing which application to run on a server. For example, HTTP
 * runs on port 80. Port number can be from 0 to 65535)
 *
 * 2. Communication
 * To exchange data over a socket connection, streams are used for input and output:
 * Input Stream: Reads data coming from the socket.
 * Output Stream: Sends data through the socket.
 * Example to access these streams:
 * // to read data
 * InputStream input = socket.getInputStream();
 * // to send data
 * OutputStream output = socket.getOutputStream();
 *
 * 3. Closing the Connection
 * The socket connection is closed explicitly once the message to the server is sent.
 * Example: Here, in the below program the Client keeps reading input from a user and sends it to the server until “Over” is typed.
 *
 * Explanation: In the above example, we have created a client program that establishes a socket connection to a server using an
 * IP address and port, enabling data exchange. The client reads messages from the user and sends them to the server until the
 * message “Over” is entered, after which the connection is closed.
 * */
public class Client {

    // Initialize socket and input/output streams
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    // Constructor to put IP address and port
    public Client(String addr, int port)
    {
        // Establish a connection
        try {
            s = new Socket(addr, port);
            System.out.println("Connected");

            // Takes input from terminal
            in = new DataInputStream(System.in);

            // Sends output to the socket
            out = new DataOutputStream(s.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }

        // String to read message from input
        String m = "";

        // Keep reading until "Over" is input
        while (!m.equals("Over")) {
            try {
                m = in.readLine();
                out.writeUTF(m);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }

        // Close the connection
        try {
            in.close();
            out.close();
            s.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Client c = new Client("127.0.0.1", 5000);
    }
}