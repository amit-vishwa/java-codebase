package reflection.section2.restrictedConstructor;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

public class WebServer {

    public void startServer(){

        try {
            HttpServer httpServer = HttpServer.create(ServerConfiguration.getServerConfiguration().getServerAddress(),0);

            httpServer.createContext("/greeting").setHandler(exchange -> {
                String responseMessage = ServerConfiguration.getServerConfiguration().getGreetingMessage();
                exchange.sendResponseHeaders(200,responseMessage.length());
                OutputStream responseBody = exchange.getResponseBody();
                responseBody.write(responseMessage.getBytes());
                responseBody.flush();
                responseBody.close();
            });

            System.out.println(String.format("Starting server on address %s: %d",
                    ServerConfiguration.getServerConfiguration().getServerAddress().getHostName(),
                    ServerConfiguration.getServerConfiguration().getServerAddress().getPort()));

            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
