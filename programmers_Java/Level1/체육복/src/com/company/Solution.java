package com.company;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n-lost.length;
        boolean[] visitReserve = new boolean[reserve.length];
        boolean[] visitLost = new boolean[lost.length];
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0 ; i<lost.length;i++)
        {
            for(int j = 0 ; j<reserve.length;j++)
            {
                if(!visitLost[i]) {
                    if(!visitReserve[j]) {
                        if (lost[i] == reserve[j]) {
                            cnt++;
                            visitLost[i] = true;
                            visitReserve[j] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (!visitLost[i]) {
                    if (reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]
                    ||lost[i] == reserve[j]) {
                        if (!visitReserve[j]) {
                            cnt++;
                            visitReserve[j] = true;
                            visitLost[i]=true;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);

        return cnt;
    }
}
