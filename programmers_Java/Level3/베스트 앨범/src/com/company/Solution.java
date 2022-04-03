package com.company;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        TreeMap<String, Integer> tm = new TreeMap<>();
        Stack<String> stack = new Stack<>();
        HashMap<String, ArrayList<int[]>> lists = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            ArrayList<int[]> tmpArr = new ArrayList<>();
            int[] tmp = {i, plays[i]};
            if (lists.containsKey(genres[i])) {
                tmpArr = (ArrayList<int[]>) lists.get(genres[i]).clone();
            }
                tmpArr.add(tmp);
                tmpArr.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o2[1] == o1[1]) {
                            return o1[0] - o2[0];
                        }
                        return o2[1] - o1[1];
                    }
                });
            lists.put(genres[i], tmpArr);
        }

        for (int i = 0; i < genres.length; i++) {
            if (tm.containsKey(genres[i]))
                tm.put(genres[i], tm.get(genres[i]) + plays[i]);
            else
                tm.put(genres[i], plays[i]);
        }

        for (String str : tm.keySet())
            stack.add(str);

        tm.clear();

        while (stack.size() != 0) {

            String targetGenre = stack.peek();
            if (lists.get(targetGenre).size() == 1) {
                result.add(lists.get(targetGenre).get(0)[0]);
            } else {
                result.add(lists.get(targetGenre).get(0)[0]);
                result.add(lists.get(targetGenre).get(1)[0]);
            }

            stack.pop();
        }

        answer=new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            answer[i]=result.get(i);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
