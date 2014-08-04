package com.coderevisited.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
    //port supposed to be 7
    public static void main(String[] args) throws IOException
    {
        ServerSocket socket = new ServerSocket(7111);
        Socket clientSocket = socket.accept();
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String nextLine;
        while ((nextLine = br.readLine()) != null) {
            System.out.println("Read from client : " + nextLine);
            writer.println(nextLine);
        }
    }
}
