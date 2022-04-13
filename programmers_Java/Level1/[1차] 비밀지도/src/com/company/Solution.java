package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer =new String[n];
        char[][] map = new char[n][n];
        String result = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                map[i][j] = ' ';
        }

        for (int i = 0; i < n; i++) {
            String tmp1 = Integer.toBinaryString(arr1[i]);
            String tmp2 = Integer.toBinaryString(arr2[i]);
            for (int j = 0; j < n; j++) {
                int arr1idx = n - tmp1.length() + j;
                int arr2idx = n - tmp2.length() + j;
                if (arr1idx < n) {
                    if (tmp1.charAt(j) == '1') {
                        map[i][arr1idx] = '#';
                    }
                }
                if(arr2idx < n){
                    if (tmp2.charAt(j) == '1') {
                        map[i][arr2idx] = '#';
                    }
                }
            }
            answer[i]= String.valueOf(map[i]);
        }

        return answer;
    }
}
