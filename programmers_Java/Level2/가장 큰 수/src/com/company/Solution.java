package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {


    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> numbersArr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++)
            numbersArr.add(String.valueOf(numbers[i]));

        numbersArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == 4) {
                    if (o1.charAt(0) == o2.charAt(0)) {
                        if (o2.length() == 4) {
                            return compare(o1.substring(1, 4), o2.substring(1, 4));
                        } else if (o2.length() == 3) {
                            return compare(o1.substring(1, 4), o2.substring(1, 3));
                        } else if (o2.length() == 2)
                            return compare(o1.substring(1, 4), o2.substring(1, o2.length()));
                    } else if (o2.length() == 1)
                        return o2.charAt(0) - o1.charAt(1);
                }
                 else if (o1.length() == 3) {
                    if (o1.charAt(0) == o2.charAt(0)) {
                        if (o2.length() == 3) {
                            return compare(o1.substring(1, 3), o2.substring(1, 3));
                        } else if (o2.length() == 2) {
                            return compare(o1.substring(1, 3), o2.substring(1, 2));
                        } else if (o2.length() == 1)
                            return o2.charAt(0) - o1.charAt(1);
                    }

                } else if (o1.length() == 2) {
                    if (o1.charAt(0) == o2.charAt(0)) {
                        if (o2.length() == 2) {
                            return compare(o1.substring(1, 2), o2.substring(1, 2));
                        } else if (o2.length() == 1)
                            return o2.charAt(0) - o1.charAt(1);
                    }
                }
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        System.out.println(numbersArr);

        for(String str : numbersArr)
        {
            answer+=str;
        }

        return answer;
    }
}
