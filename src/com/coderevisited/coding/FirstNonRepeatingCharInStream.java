package com.coderevisited.coding;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
