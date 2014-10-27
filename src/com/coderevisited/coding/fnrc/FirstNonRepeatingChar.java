package com.coderevisited.coding.fnrc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Maintain LinkedHashMap, key as character and value as number occurrences. For each each character read, update the
 * value. At the end by going through the map. return the first character that has value 1
 */
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

        index = firstNonRepeatingCharImproved(str);
        if (index == -1)
        {
            System.out.println("All characters are repeated");
        } else
        {
            System.out.println("Non repeating char by Improved method: " + str.charAt(index));
        }
    }

    public static int firstNonRepeatingChar(String str)
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

    public static int firstNonRepeatingCharImproved(String str)
    {
        Map<Character, CounterIndex> hist = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (!hist.containsKey(c))
            {
                hist.put(c, new CounterIndex(i));
            } else
            {
                hist.get(c).incrementCount();
            }
        }

        for(CounterIndex index : hist.values()){
            if(index.getCount() == 1){
                return index.getFirstPos();
            }
        }

        return -1;
    }


    private static class CounterIndex
    {
        int count;
        private final int firstPos;

        public CounterIndex(int firstPos)
        {
            this.count = 1;
            this.firstPos = firstPos;
        }

        public void incrementCount()
        {
            count++;
        }

        public int getFirstPos()
        {
            return firstPos;
        }

        public int getCount()
        {
            return count;
        }
    }
}
