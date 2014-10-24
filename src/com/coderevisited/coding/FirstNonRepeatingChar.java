package com.coderevisited.coding;

public class FirstNonRepeatingChar
{
    public static void main(String[] args)
    {
        String str = "Given a string, find its first non repeating character";
        int index = firstNonRepeatingChar(str);
        if (index == -1)
        {
            System.out.println("All characters are repeated");
        } else
        {
            System.out.println("Non repeating char : " + str.charAt(index));
        }
    }

    private static int firstNonRepeatingChar(String str)
    {
        int[] hist = new int[256];
        for (char c : str.toCharArray())
        {
            hist[c]++;
        }

        for (int i = 0; i < str.length(); i++)
        {
            if (hist[str.charAt(i)] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}
