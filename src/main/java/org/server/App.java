package org.server;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Server server = new Server();
        server.start();
    }
}
