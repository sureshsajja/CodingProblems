package com.coderevisited.strings;

/**
 * Add s1 to itself. find if s2 is it's part (s1+s1)
 */
public class RotationsOfEachOther
{
    public static void main(String[] args)
    {
        String s1 = "ABCD";
        String s2 = "CDAB";
        if (areRotations(s1, s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        s1 = "ABCD";
        s2 = "ACBD";
        if (areRotations(s1, s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean areRotations(String s1, String s2)
    {

        String temp = s1 + s1;

        return temp.contains(s2);
    }
}
