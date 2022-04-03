package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean[] visit;
    public ArrayList<String> strArr = new ArrayList<>();
    public void comb(String answer, int[] numbers,int cnt){
        if(cnt==numbers.length)
        {
            strArr.add(answer);
            strArr.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1)-Integer.parseInt(o2);
                }
            });
            if(strArr.size()==2)
            {
                strArr.remove(0);
            }
            return ;
        }
        for(int i = 0 ; i <numbers.length;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                comb(answer+numbers[i], numbers,cnt+1);
                comb(answer,numbers,cnt);
                visit[i]=false;
            }
        }

    }

    public String solution(int[] numbers) {
        visit = new boolean[numbers.length];
        String answer = "";

        comb("",numbers,0);
        System.out.println(strArr);

        return strArr.get(0);
    }
}