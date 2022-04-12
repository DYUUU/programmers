package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        s = s.substring(1, s.length() - 1);
        int startIdx = 0;
        int endIdx = 0;
        LinkedList<LinkedList<Integer>> comb = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                startIdx = i;
            } else if (s.charAt(i) == '}') {
                endIdx = i;
            }

            if (endIdx != 0) {
                String tmp = s.substring(startIdx + 1, endIdx);
                String[] tmpStr = tmp.split(",");
                LinkedList<Integer> tmpInt = new LinkedList<>();
                for (int j = 0; j < tmpStr.length; j++) {
                    tmpInt.add(Integer.valueOf(tmpStr[j]));
                }
                comb.add(tmpInt);

                startIdx = 0;
                endIdx = 0;
            }
        }

        comb.sort(new Comparator<LinkedList<Integer>>() {
            @Override
            public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        for (int i = 0; i < comb.size(); i++) {
            LinkedList<Integer> tmp = (LinkedList<Integer>) comb.get(i).clone();
            for (int j = 0; j < tmp.size(); j++) {
                if (queue.contains(tmp.get(j))) {
                    continue;
                } else{
                    queue.add(tmp.get(j));
                }
            }
        }

        answer=new int[queue.size()];
        for(int i = 0 ; queue.size()!=0;i++)
        {
            answer[i]=queue.poll();
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
