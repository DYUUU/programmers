package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                result.add(arr[i]);
            }
        }

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        if (result.size() == 0) {
            return new int[]{-1};
        } else {
            answer = new int[result.size()];
            for (int i = 0; i < result.size();i++ )
                answer[i] = result.get(i);
            return answer;
        }
    }
}
