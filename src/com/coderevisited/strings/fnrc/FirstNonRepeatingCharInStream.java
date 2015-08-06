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

package com.coderevisited.strings.fnrc;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Maintain a LinkedHashSet. If current char is already existed in the set, remove it. Else add that char in the set. At
 * any point return the first element in the set
 */
public class FirstNonRepeatingCharInStream
{

    private static final int BUFFER_SIZE = 8;
    //If we have to save the pos of char.. we should use LinkedHashMap
    private static Set<Character> set = new LinkedHashSet<>();

    public static void main(String[] args)
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))))
        {
            String sizeStr = reader.readLine();
            int N = Integer.valueOf(sizeStr);
            char[] chars = new char[BUFFER_SIZE];
            int size = N / BUFFER_SIZE + 1;
            for (int i = 0; i < size; i++)
            {
                int len = reader.read(chars);
                for (int j = 0; j < len; j++)
                {
                    char c = findNonRepeatingChar(chars[j]);
                    pw.println(c);

                }
            }
        } catch (IOException e)
        {
            //ignore
        } finally
        {
            try
            {
                reader.close();
            } catch (IOException e)
            {
                //ignore
            }
        }

    }

    private static char findNonRepeatingChar(char c)
    {
        if (set.contains(c))
        {
            set.remove(c);
        } else
        {
            set.add(c);
        }
        return set.iterator().next();
    }
}
