package com.company;

import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            int num1 = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int num2 = numbers[j];
                int sum = num1+num2;
                if(!result.contains(sum))
                    result.add(sum);
            }
        }

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        answer = new int[result.size()];

        for(int i = 0 ;i < result.size();i++)
            answer[i]=result.get(i);

        return answer;
    }
}
