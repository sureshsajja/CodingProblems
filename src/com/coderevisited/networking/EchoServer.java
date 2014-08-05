package com.coderevisited.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.coderevisited.concurrency.ExecutorUtils;

/**
 * TCP Server that accepts multiple clients
 */
public class EchoServer
        implements Closeable
{

    private final ServerSocket socket;
    private ExecutorService service;

    public EchoServer() throws IOException
    {
        socket = new ServerSocket(7);
        service = ExecutorUtils.newCachedThreadPool("Server");
    }

    //port supposed to be 7
    public static void main(String[] args) throws IOException
    {
        final EchoServer server = new EchoServer();
        ExecutorService service = ExecutorUtils.singleThreadPoolExecutor("Server");

        Future<Boolean> result = service.submit(new Callable<Boolean>()
        {
            @Override
            public Boolean call()
            {
                try {
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter '#' to quit()");
                    String exitHook;
                    do {
                        exitHook = stdIn.readLine();
                    } while (!exitHook.equalsIgnoreCase("#"));
                    System.out.println("calling socket.close()");
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        while (!result.isDone()) {
            //wait for next client
            server.connect();
        }
        service.shutdown();
    }

    public void connect()
    {
        try {
            final Socket clientSocket = socket.accept();
            service.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    try {
                        //Client is connected.. Read from socket and write the same message to the socket
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()));

                        String nextLine;
                        while ((nextLine = br.readLine()) != null) {
                            System.out.println("Read from client : " + nextLine);
                            writer.println(nextLine);
                        }
                    } catch (IOException e) {
                        System.out.println(String.format("Error while communicating with client: %s", e.getMessage()));
                    }
                }
            });
        } catch (IOException e) {
            System.out.println(String.format("server.accept() is interrupted: %s", e.getMessage()));
        }
    }

    @Override
    public void close()
    {
        try {
            socket.close();
        } catch (IOException e) {
            //ignore
        }
        service.shutdown();
    }
}
