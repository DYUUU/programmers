package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, LinkedList<String>> reportedList = new HashMap<>();
        HashMap<String, Integer> reportCnt = new HashMap<>();
        LinkedList<String> unavailable = new LinkedList<>();

        for (int i = 0; i < id_list.length; i++) {
            reportedList.put(id_list[i], new LinkedList<>());
            reportCnt.put(id_list[i], 0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            LinkedList<String> tmpLinkedList = new LinkedList<>(reportedList.get(tmp[0]));

            if (!tmpLinkedList.contains(tmp[1])) {
                tmpLinkedList.add(tmp[1]);
                reportCnt.put(tmp[1], reportCnt.get(tmp[1]) + 1);
            }

            reportedList.put(tmp[0], tmpLinkedList);
        }

        for (String str : reportCnt.keySet()) {
            if (reportCnt.get(str) >= k) {
                unavailable.add(str);
            }
        }

        for (int i = 0; i < reportedList.size(); i++) {
            for (String s : unavailable) {
                if (reportedList.get(id_list[i]).contains(s)) {
                    answer[i]++;
                }
            }
        }


        System.out.println(Arrays.toString(answer));


        return answer;
    }
}
