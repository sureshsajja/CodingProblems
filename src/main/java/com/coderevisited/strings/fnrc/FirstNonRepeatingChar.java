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
