package com.company;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList();
        int idx = 0;
        for(int i = 0 ;i <arr.length;i++)
        {
            if(arrayList.isEmpty()) {
                arrayList.add(arr[i]);
            }
            else
            {
                if(arrayList.get(idx)==arr[i])
                    continue;
                else
                {
                    arrayList.add(arr[i]);
                    idx++;
                }
            }
        }

        answer = new int[arrayList.size()];

        for(int i=0;i<arrayList.size();i++)
            answer[i]=arrayList.get(i);

        return answer;
    }
}