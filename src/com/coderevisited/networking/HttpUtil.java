package com.coderevisited.networking;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil
{
    public static void main(String[] args) throws IOException
    {
        String url = "https://www.google.co.in";
        URLConnection uc = getHttpUrlConnection(url);
        BufferedInputStream br = new BufferedInputStream(uc.getInputStream());
        int i = br.read();
        System.out.printf("Bytes read " + i);
        br.close();
    }


    public static URLConnection getHttpUrlConnection(String url)
    {
        try {
            URLConnection uc = new URL(url).openConnection();
            uc.connect();
            return uc;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
