package com.company;

public class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        double[] scores = new double[3];
        int idx = 0;
        char[] result = dartResult.toCharArray();
        boolean flag = false;

        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 'A' && result[i] <= 'Z') {
                // Single
                if (result[i] == 'S') {
                    scores[idx-1] = Math.pow(scores[idx-1], 1);
                }
                // Double
                else if (result[i] == 'D') {
                    scores[idx-1] = Math.pow(scores[idx-1], 2);
                }
                // Treeple
                else if (result[i] == 'T') {
                    scores[idx-1] = Math.pow(scores[idx-1], 3);
                }
            } else if (result[i] >= '0' && result[i] <= '9') {
                if (result[i] == '1') {
                    if (result[i + 1] == '0') {
                        scores[idx] = 10;
                        idx++;
                        flag = true;
                        continue;
                    }
                }
                if (flag)
                {
                    flag=false;
                    continue;
                }
                scores[idx] += Double.valueOf(String.valueOf(result[i]));
                idx++;
            } else {
                if (result[i] == '*') {
                    if(idx>=2)
                    {
                        scores[idx-1] *= 2;
                        scores[idx-2] *= 2;
                    }
                    else
                    {
                        scores[idx-1] *= 2;
                    }
                } else if (result[i] == '#') {
                    scores[idx-1] *= -1;
                }
            }
        }
        for(int i = 0 ; i < 3 ; i++)
            answer+=scores[i];

        return answer;
    }
}
