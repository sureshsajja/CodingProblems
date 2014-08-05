package com.coderevisited.networking;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TCP Client that waits for server availability to get connected. If server is down, it again tries to connect to
 * server based on user input
 */
public class EchoClient
        implements Closeable
{
    private static final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private Socket socket;
    private AtomicReference<State> state = new AtomicReference<State>(State.INIT);

    public static void main(String[] args) throws IOException
    {
        EchoClient client = new EchoClient();
        do {
            System.out.println("Present state of the client: " + client.getState());
            System.out.println("Options:");
            System.out.println("Enter 'GO' to connect");
            System.out.println("Enter '#' to exit");
            String input = stdIn.readLine();
            while (!("#".equalsIgnoreCase(input) || "GO".equalsIgnoreCase(input))) {
                stdIn.readLine();
            }

            if ("GO".equalsIgnoreCase(input)) {
                client.connect();
                System.out.println("Present state of the client: " + client.getState());
                client.communicate();
            } else {
                client.setState(State.CLOSED);
            }
        } while (!client.getState().equals(State.CLOSED.toString()));
        client.close();
    }

    public String getState()
    {
        return state.get().toString();
    }

    public void setState(State _state)
    {
        state.set(_state);
    }

    public void connect()
    {
        //port supposed to be 7
        socket = new Socket();
        do {
            try {
                socket.connect(new InetSocketAddress(7));
            } catch (IOException e) {
                System.out.println(String.format("Failed to connect to server at port 7: %s", e.getMessage()));
                try {
                    System.out.println("Retrying after 10 sec");
                    Thread.sleep(10000);
                    socket = new Socket();
                } catch (InterruptedException e1) {
                    //
                }
            }
        } while (!socket.isConnected());
        state.set(State.CONNECTED);
    }

    public void communicate()
    {
        try {
            //socket is ready.. Read from std.in write to the socket.
            //wait for reading from socket
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Enter message to server");
            System.out.println("Enter $ to quit client:");
            String userInput = stdIn.readLine();
            while (!"$".equalsIgnoreCase(userInput)) {
                writer.println(userInput);
                System.out.println("Echo from server: " + reader.readLine());
                userInput = stdIn.readLine();
            }
            socket.close();
            state.set(State.CLOSED);
        } catch (IOException e) {
            System.out.println(String.format("communication with server is failed with error : %s", e.getMessage()));
            state.set(State.SUSPENDED);
        }

    }

    @Override
    public void close() throws IOException
    {
        socket.close();
    }

    private static enum State
    {
        INIT
                {
                    public String toString()
                    {
                        return "INIT";
                    }
                },
        CONNECTED
                {
                    public String toString()
                    {
                        return "CONNECTED";
                    }
                },
        SUSPENDED
                {
                    public String toString()
                    {
                        return "SUSPENDED";
                    }
                },
        CLOSED
                {
                    public String toString()
                    {
                        return "CLOSED";
                    }
                }
    }
}
