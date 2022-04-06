package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        LinkedList<Integer> result = new LinkedList<>();

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int i = 0;
        while (i < answers.length) {
            if (cnt1 >= first.length)
                cnt1 = 0;
            if (cnt2 >= second.length)
                cnt2 = 0;
            if (cnt3 >= third.length)
                cnt3 = 0;

            if (first[cnt1] == answers[i])
                score[0] += 1;
            if (second[cnt2] == answers[i])
                score[1] += 1;
            if (third[cnt3] == answers[i])
                score[2] += 1;
            cnt1++;
            cnt2++;
            cnt3++;
            i++;
        }

        int max = 0;
        for (int tmp : score) {
            if (max < tmp) {
                max = tmp;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (score[j] == max)
                result.add(j + 1);
        }

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        answer = new int[result.size()];
        for(int j = 0 ; j<result.size();j++)
            answer[j]=result.get(j);

        return answer;
    }
}
