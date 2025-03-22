package reflection.section2.restrictedConstructor;

import java.net.InetSocketAddress;

public class ServerConfiguration {

    private static ServerConfiguration serverConfiguration;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfiguration(int port, String greetingMessage) {
        this.serverAddress = new InetSocketAddress("localhost", port);
        this.greetingMessage = greetingMessage;

        if(serverConfiguration == null){
            serverConfiguration = this;
        }
    }

    public static ServerConfiguration getServerConfiguration() {
        return serverConfiguration;
    }

    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

}
