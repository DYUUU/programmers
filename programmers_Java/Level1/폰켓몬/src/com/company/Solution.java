package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int answer = 0;
        //BFS
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        int sort = nums.length / 2;
        if (hashSet.size() >= sort) {
            answer = sort;
        } else {
            answer = hashSet.size();
        }

        return answer;
    }
}
