package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> numbersArr = new ArrayList<>();

        Arrays.stream(numbers).sorted();

        for (int i = 0; i < numbers.length; i++)
            numbersArr.add((numbers[i]));

        // 1 내림차순 정렬
        numbersArr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 >= 10) {
                    if (o2 < 10) {
                        if (o1 / 10 <= o2) {
                            if (o1 % 10 == 0)
                                return o1 - o2;
                            else
                                return o2 - o1;
                        }
                    } else {
                        return o2 - o1;
                    }
                } else if (o2 >= 10) {
                    if (o1 < 10) {
                        if (o2 / 10 <= o1) {
                            if (o2 % 10 == 0)
                                return o2 - o1;
                            else
                                return o1-o2;
                        }
                    } else {
                        return o1 - o2;
                    }
                }
                return o2 - o1;
            }
        });

        System.out.println(numbersArr);

        for (int tmp : numbersArr) {
            answer += tmp;
        }


        if (answer.charAt(0) == '0')
            return "0";
        else
            return answer;
    }
}
