package com.coderevisited.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient
{
    public static void main(String[] args) throws IOException
    {
        //port supposed to be 7
        Socket socket = new Socket("localhost", 7111);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdin.readLine()) != null) {
            writer.println(userInput);
            System.out.println("Echo from server: " + reader.readLine());
        }
    }
}
