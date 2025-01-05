package tutorial.java.networking;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Refer: https://www.geeksforgeeks.org/url-class-java-examples/?ref=lbp
 *
 * URL known as Uniform Resource Locator is simply a string of text that identifies all the resources on the Internet, telling us
 * the address of the resource, how to communicate with it, and retrieve something from it.
 *
 * A URL can have many forms. The most general however follows a three-components system as proposed below:
 * Protocol: HTTP is the protocol here
 * Hostname: Name of the machine on which the resource lives.
 * File Name: The pathname to the file on the machine.
 * Port Number: Port number to which to connect (typically optional).
 *
 * URL Class
 * The URL class is the gateway to any of the resources available on the internet. A Class URL represents a Uniform Resource
 * Locator, which is a pointer to a “resource” on the World Wide Web. A resource can point to a simple file or directory, or it
 * can refer to a more complicated object, such as a query to a database or to a search engine.
 * */
public class URLClassExample {

    // Main driver method
    public static void main(String[] args)
            throws MalformedURLException
    {

        // Creating a URL with string representation
        URL url1 = new URL(
                "https://www.google.co.in/?gfe_rd=cr&ei=ptYq"
                        + "WK26I4fT8gfth6CACg#q=geeks+for+geeks+java");

        // Creating a URL with a protocol,hostname,and path
        URL url2 = new URL("http", "www.geeksforgeeks.org",
                "/jvm-works-jvm-architecture/");

        URL url3 = new URL(
                "https://www.google.co.in/search?"
                        + "q=gnu&rlz=1C1CHZL_enIN71"
                        + "4IN715&oq=gnu&aqs=chrome..69i57j6"
                        + "9i60l5.653j0j7&sourceid=chrome&ie=UTF"
                        + "-8#q=geeks+for+geeks+java");

        // Printing the string representation of the URL
        System.out.println("URL1: " + url1.toString());
        System.out.println("URL2: " + url2.toString());
        System.out.println();
        System.out.println(
                "Different components of the URL3:");

        // Retrieving the protocol for the URL
        System.out.println("Protocol:- "
                + url3.getProtocol());

        // Retrieving the hostname of the url
        System.out.println("Hostname:- " + url3.getHost());

        // Retrieving the default port
        System.out.println("Default port:- "
                + url3.getDefaultPort());

        // Retrieving the query part of URL
        System.out.println("Query:- " + url3.getQuery());

        // Retrieving the path of URL
        System.out.println("Path:- " + url3.getPath());

        // Retrieving the file name
        System.out.println("File:- " + url3.getFile());

        // Retrieving the reference
        System.out.println("Reference:- " + url3.getRef());
    }

}
