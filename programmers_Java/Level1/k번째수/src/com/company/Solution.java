package com.company;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for (int i = 0; i < commands.length; i++) {
            int num = commands[i][1] - commands[i][0] + 1;
            int[] tmp = new int[num];
            for (int k = 0; k < num; ) {
                for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; k++, j++) {
                    tmp[k] = array[j];
                }
            }
            Arrays.sort(tmp);
            answer[i]=tmp[commands[i][2]-1];
        }


        System.out.println(Arrays.toString(answer));

        return answer;
    }
}