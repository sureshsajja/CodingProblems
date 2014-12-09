package com.coderevisited.strings;

import java.util.List;

import com.coderevisited.bits.GenerateNBitGrayCodes;

public class PossibleStringsByPlacingSpaces
{

    public static void main(String[] args)
    {
        String s = "ABC";
        int length = s.length() - 1;
        List<String> codes = GenerateNBitGrayCodes.generateGrayCode(length);
        printStrings(s, codes);
    }


    private static void printStrings(String s, List<String> codes)
    {
        char[] chars = s.toCharArray();
        for (String code : codes) {
            char[] codeChars = code.toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                System.out.print(chars[i]);
                if (codeChars[i] == '1') {
                    System.out.print(" ");
                }
            }
            System.out.print(chars[chars.length - 1]);
            System.out.println();
        }
    }

}
