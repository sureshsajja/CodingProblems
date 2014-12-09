package com.coderevisited.bits;

import java.util.ArrayList;
import java.util.List;

public class GenerateNBitGrayCodes
{
    public static void main(String[] args)
    {
        List<String> list = generateGrayCode(8);
        for (String code : list) {
            System.out.println(code);
        }
    }

    public static List<String> generateGrayCode(int n)
    {
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        List<String> prev = generateGrayCode(n - 1);
        List<String> list = new ArrayList<>();
        for (String str : prev) {
            list.add("0" + str);
        }

        for (int i = prev.size() - 1; i >= 0; i--) {
            list.add("1" + prev.get(i));
        }

        return list;
    }
}
