package com.company;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int j = 0;

        for (int i = 0; i < moves.length; i++) {
            while (board[j][moves[i] - 1] == 0) {
                j++;
                if (j == board.length-1) {
                    break;
                }
            }
            if (!basket.isEmpty()) {
                if (basket.peek() == board[j][moves[i] - 1]) {
                    basket.pop();
                    answer += 2;
                    j = 0;
                    continue;
                }
            }
            if(board[j][moves[i] - 1]!=0) {
                basket.add(board[j][moves[i] - 1]);
                board[j][moves[i] - 1] = 0;
            }
                j = 0;
        }

        System.out.println(answer);

        return answer;
    }
}
