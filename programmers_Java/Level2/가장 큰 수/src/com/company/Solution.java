package com.company;

public class Solution {
    public boolean[] visit;
    public String min = "0";
    public void comb(String answer, int[] numbers,int cnt){
        if(cnt==numbers.length)
        {
            if(Long.valueOf(min)<Long.valueOf(answer))
            {
                min=answer;
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
        System.out.println(min);

        return min;
    }
}
