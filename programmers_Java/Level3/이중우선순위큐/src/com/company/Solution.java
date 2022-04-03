package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            if (str[0].equals("I")) {
                    arr.add(num);
                        arr.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1 - o2;
                            }
                        });
            } else if (str[0].equals("D")) {
                if(!arr.isEmpty()) {
                    if (num == 1) {
                        arr.remove(arr.size() - 1);
                    } else {
                        arr.remove(0);
                    }
                }
            }
        }

        if(!arr.isEmpty()) {
            answer[0] = arr.get(arr.size() - 1);
            answer[1] = arr.get(0);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
