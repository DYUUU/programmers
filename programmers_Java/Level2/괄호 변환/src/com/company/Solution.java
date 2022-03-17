package com.company;

public class Solution {
    public String result = "";

    public void DFS(StringBuilder u, StringBuilder v) {

        if (String.valueOf(u).equals("()")) {
            result += u;
        } else {
            u.delete(0, 1);
            u.delete(u.length() - 1, u.length());
            String str = String.valueOf(u.reverse());
            if(str.equals("()"))
                result += '(' + str + ')';
            else
                result += '(' + String.valueOf(u.reverse()) + ')';
        }
        if (String.valueOf(v).equals("()") || String.valueOf(v).equals("")) {
            result += v;
        } else {
            int index = div(String.valueOf(v));
            DFS(new StringBuilder(v.substring(0, index)), new StringBuilder(v.substring(index, v.length())));
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
        int index = div(p);
            DFS(new StringBuilder(p.substring(0, index)), new StringBuilder(p.substring(index, p.length())));
        System.out.println(result);

        return result;
    }
}