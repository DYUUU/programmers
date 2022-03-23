package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        boolean flag = true;
        LinkedList<LinkedList<String>> banned_id_linkedList = new LinkedList<>();

        for (int i = 0; i < banned_id.length; i++) {
            LinkedList<String> banned_id_arr = new LinkedList<>();
            banned_id_arr.add(banned_id[i]);
            for (int j = 0; j < user_id.length; j++) {
                for (int k = 0; k < banned_id[i].length(); k++) {
                    if (banned_id[i].length() != user_id[j].length()) {
                        flag = false;
                        break;
                    }
                    if (banned_id[i].charAt(k) == '*') {
                        continue;
                    } else if (banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    banned_id_arr.add(user_id[j]);
                } else
                    flag = true;
            }
            banned_id_linkedList.add(banned_id_arr);
        }

        System.out.println(banned_id_linkedList);

        // 다중 방문처리를 못하겠음!

        return answer;
    }
}
