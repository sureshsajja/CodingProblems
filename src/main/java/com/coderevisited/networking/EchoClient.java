/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
            System.out.println("Enter # to quit client:");
            String userInput = stdIn.readLine();
            while (!"#".equalsIgnoreCase(userInput)) {
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
        INIT,
        CONNECTED,
        SUSPENDED,
        CLOSED
    }
}
