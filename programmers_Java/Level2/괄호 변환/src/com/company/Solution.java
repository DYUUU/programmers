package com.company;

public class Solution {

    public String DFS(StringBuilder u, StringBuilder v) {
        int index = 0;
        String resultOfV="";

        if(v.length()!=0) {
            index = div(String.valueOf(v));
            resultOfV = DFS(new StringBuilder(v.substring(0, index)), new StringBuilder(v.substring(index, v.length())));
        }
        if(u.charAt(u.length()-1)=='(')
        {
            // 새로운 문자열 만들기
            u.delete(0,1);
            u.delete(u.length()-1,u.length());
            String tmp = "("+resultOfV+")"+u.reverse();
            return tmp;
        } else {
            return u + resultOfV;
        }

    }

    public int div(String str) {
        char[] ch = str.toCharArray();
        int cnt = 0;
        int index = 0;
        for (char c : ch) {
            index++;
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            if (cnt == 0)
                break;
        }
        return index;
    }

    public String solution(String p) {
        String answer = "";
        int index = div(p);
        answer = DFS(new StringBuilder(p.substring(0, index)), new StringBuilder(p.substring(index, p.length())));

        System.out.println(answer);

        return answer;
    }
}