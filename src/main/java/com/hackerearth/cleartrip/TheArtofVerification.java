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

package com.hackerearth.cleartrip;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  28/06/15
 * Version : v1
 */
public class TheArtofVerification {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        String s = next();
        URL url = new URL(s);
        String query = url.getQuery();
        int username = query.indexOf("username");
        int pwd = query.indexOf("pwd");
        int profile = query.indexOf("profile");
        int role = query.indexOf("role");
        int key = query.indexOf("key");

        String s1 = query.substring(username, pwd-1);
        String s2 = query.substring(pwd, profile-1);
        String s3 = query.substring(profile, role-1);
        String s4 = query.substring(role, key-1);
        String s5 = query.substring(key);

        pw.println("username: " + s1.substring(s1.indexOf("=") + 1));
        pw.println("pwd: " + s2.substring(s2.indexOf("=") + 1));
        pw.println("profile: " + s3.substring(s3.indexOf("=") + 1));
        pw.println("role: " + s4.substring(s4.indexOf("=") + 1));
        pw.println("key: " + s5.substring(s5.indexOf("=") + 1));



        reader.close();
        pw.close();
    }
}
