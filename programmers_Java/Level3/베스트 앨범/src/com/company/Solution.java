package com.company;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> lists = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();


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
            if (hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
            } else {
                hashMap.put(genres[i], plays[i]);
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        System.out.println(list);


        for (int i = 0 ; i< list.size();i++)
            stack.add(list.get(i).getKey());

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

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
