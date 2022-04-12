package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution1 {
    public String[] solution(String path) {
        String[] answer = {};
        int distance = 0;
        String turn = "";
        int time = 0;
        Stack<Character> stack = new Stack();
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < path.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(path.charAt(i));
                i++;
            }
            if (i >= path.length()-1) {
                break;
            }
            while (path.charAt(i) == stack.peek()) {
                stack.add(path.charAt(i));
                i++;
                if (i >= path.length()-1) {
                    break;
                }
            }
            distance = stack.size() * 100;
            while (distance > 500) {
                time++;
                distance -= 100;
            }
            if (stack.peek() == 'E') {
                if (path.charAt(i) == 'S') {
                    turn = "right";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                } else if (path.charAt(i) == 'N') {
                    turn = "left";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                }
            } else if (stack.peek() == 'W') {
                if (path.charAt(i) == 'S') {
                    turn = "left";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                } else if (path.charAt(i) == 'N') {
                    turn = "right";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                }

            } else if (stack.peek() == 'S') {
                if (path.charAt(i) == 'E') {
                    turn = "left";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                } else if (path.charAt(i) == 'W') {
                    turn = "right";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                }
            } else if (stack.peek() == 'N') {
                if (path.charAt(i) == 'E') {
                    turn = "right";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                } else if (path.charAt(i) == 'W') {
                    turn = "left";
                    list.add("Time " + time + ": Go stragiht " + distance + "m and turn " + turn);
                    time += distance / 100;
                }
            }

            i--;
            stack.clear();
        }

        answer = new String[list.size()];
        for(int i = 0 ; i <list.size();i++)
        {
            answer[i]=list.get(i);
        }

        System.out.println(list);

        return answer;
    }

}
