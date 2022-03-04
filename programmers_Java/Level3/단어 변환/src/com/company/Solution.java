package com.company;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public boolean[] wordsCheck;
    public HashSet<String> result = new HashSet<>();
    public int min = Integer.MAX_VALUE;

    public void findMinProgress(String str,String target, ArrayList<String> words, int beginIndex) {
        if (str.equals(target)||beginIndex>=str.length()) {
            if(result.size()<min)
                min= result.size();
            return;
        } else {
                if (!wordsCheck[beginIndex]) {
                    /* 타겟 값이랑 일치하는 값이 있는지 확인 */
                    for (int i = 0; i < str.length()&&!str.equals(target); i++) {
                        String mix = str.substring(0, i) + target.charAt(i) + str.substring(i + 1, str.length());

                        if (words.contains(mix)) {
                            result.add(mix);
                            wordsCheck[i] = true;
                            words.remove(mix);
                            str=mix;
                            findMinProgress(mix, target, words, 0);
                        }
                    }
                    for (int i = 0; i < words.size(); i++) {
                        String tmp = str.substring(0, beginIndex) + str.substring(beginIndex + 1, str.length());
                        String word = words.get(i).substring(0, beginIndex) + words.get(i).substring(beginIndex + 1, words.get(i).length());
                        if (tmp.equals(word)) {
                            result.add(words.get(i));
                            str = words.get(i);
                            words.remove(i);
                            findMinProgress(str, target, words, 0);
                        }
                    }
                }

            }
            findMinProgress(str,target, words, beginIndex + 1);
        }

    public int solution(String begin, String target, String[] words) {
        wordsCheck = new boolean[begin.length()];
        ArrayList<String> arr = new ArrayList<String>(List.of(words));

        if (!arr.contains(target)) {
            return 0;
        } else {
            for(int i = 0;i<begin.length();i++)
            {
                if(begin.charAt(i)==target.charAt(i))
                {
                    wordsCheck[i]=true;
                }
            }
                findMinProgress(begin, target, arr, 0);
            System.out.println(min);
            return min;
        }
    }
}