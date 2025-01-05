package tutorial.java.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Refer: https://www.geeksforgeeks.org/java-networking/?ref=lbp
 *
 * InetAddress
 * The InetAddress class is used to provide methods to get the IP address of any hostname. An IP address is expressed by 32-bit
 * or 128-bit unsigned number. An object of InetAddress describes the IP address with its analogous hostname. InetAddress can
 * control both IPv4 and IPv6 addresses.
 *
 * There are two different types of addresses:
 * Unicast – It is an identifier for a single interface.
 * Multicast – It is an identifier for a collection of interfaces.
 * */
public class InetAddressExample {

    public static void main(String[] args) throws UnknownHostException{

        exampleOne();
        exampleTwo();

    }

    static void exampleOne() throws UnknownHostException {
        // To get and print InetAddress of the Local Host
        InetAddress address = InetAddress.getLocalHost();

        System.out.println("InetAddress of the Local Host : "+address);

        // To get and print host name of the Local Host
        String hostName=address.getHostName();

        System.out.println("Host name of the Local Host : "+hostName);
    }

    static void exampleTwo() throws UnknownHostException {
        // To get and print InetAddress of Named Hosts
        InetAddress address1 = InetAddress.getByName(
                "write.geeksforgeeks.org");

        System.out.println("\nInet Address of named hosts : "
                + address1);

        // To get and print ALL InetAddress of Named Host
        InetAddress arr[] = InetAddress.getAllByName(
                "www.geeksforgeeks.org");

        System.out.println("Inet Address of ALL named hosts :");

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }

}
