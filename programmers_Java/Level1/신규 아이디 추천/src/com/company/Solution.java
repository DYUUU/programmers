package com.company;

import java.util.LinkedList;

public class Solution {
    public String solution(String new_id) {
        String answer = "";
        LinkedList<Character> id = new LinkedList<>();

        for (int i = 0; i < new_id.length(); i++)
            id.add(new_id.charAt(i));

        for (int i = 0; i < id.size(); i++) {
            //1
            if (id.get(i) >= 'A' && id.get(i) <= 'Z') {
                id.set(i, Character.toLowerCase(id.get(i)));
            }
            //2
            if (id.get(i) >= 'a' && id.get(i) <= 'z' ||
                    id.get(i) >= '0' && id.get(i) <= '9' || id.get(i) == '-' || id.get(i) == '_' || id.get(i) == '.') {
            } else {
                id.remove(i);
                i--;
            }
            //3
            if (i > 0) {
                if (id.get(i) == '.' && id.get(i - 1) == '.') {
                    id.remove(i);
                    i--;
                }
            }
        }

        //4
        for (int i = 0; i < id.size(); i++) {
            if (id.get(i) == '.') {
                if (i == 0 || i == id.size() - 1) {
                    id.remove(i);
                    i--;
                }
            }
        }

        //6

        // 5
        if (id.isEmpty()) {
            id.add('a');
            id.add('a');
            id.add('a');
        } else {
            //6
            while (id.size() > 15) {
                id.remove(id.size() - 1);
            }
            if(id.get(id.size()-1)=='.')
                id.remove(id.size()-1);

            if (id.size() <= 2) {
                //7
                while (id.size() != 3) {
                    id.add(id.get(id.size() - 1));
                }
            }
        }
        for (char ch : id) {
            answer += ch;
        }

        System.out.println(answer);

        return answer;

    }
}
