package com.company;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    if (basket.isEmpty())
                        basket.add(board[j][moves[i] - 1]);
                    else {
                        if (basket.peek() == board[j][moves[i] - 1]) {
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.add(board[j][moves[i] - 1]);
                        }
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        System.out.println(answer);

        return answer;
    }
}
