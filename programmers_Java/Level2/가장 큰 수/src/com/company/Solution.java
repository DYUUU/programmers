package com.company;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Solution {

    public String solution(int[] numbers) {
        String answer = "";
        LinkedList<String> numberList = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++)
            numberList.add(String.valueOf(numbers[i]));

        numberList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == 2) {
                    if (o2.length() == 2)
                        return Integer.parseInt(o2) - Integer.parseInt(o1);
                    else if (o2.length() == 1) {
                        if (o1.charAt(1)>o2.charAt(0))
                        {
                            return o2.charAt(0)-o1.charAt(1);
                        }
                        else{
                            return o1.length()-o2.length();
                        }
                    }
                }
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        for(String str : numberList)
        {
            answer+=str;
        }

        System.out.println(answer);

        return answer;
    }
}
