package com.company;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public LinkedList<LinkedList<String>> banned_id_linkedList = new LinkedList<>();
    public int banned_list;
    public HashSet<HashSet<String>> result = new HashSet<>();

    public void DFS(HashSet<String> comb,int row,int col)
    {
        if(row== banned_id_linkedList.size())
        {
            if(banned_list==comb.size()) {
                System.out.println(comb);
                result.add((HashSet<String>) comb.clone());
            }
        }
        else {
            LinkedList<String> tmp = (LinkedList<String>) banned_id_linkedList.get(row).clone();
            if(col==tmp.size()-1)
            {
                return;
            }
            else {
                tmp.remove(0);
                DFS((HashSet<String>) comb.clone(), row, col + 1);
                comb.add(tmp.get(col));
                DFS((HashSet<String>) comb.clone(), row + 1, 0);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        boolean flag = true;
        banned_list=banned_id.length;

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

        DFS(new HashSet<String>(),0,0);

        return result.size();
    }
}
