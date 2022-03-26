package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public String solution(String play_time, String adv_time, String[] logs) throws ParseException {
        String answer = "";
        ArrayList<ArrayList<String>> dates = new ArrayList<>();
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        Arrays.stream(logs).sorted();

        for(int i = 0 ; i< logs.length;i++)
        {
            String[] tmpStr = logs[i].split("-");
            ArrayList<String> tmpArr = new ArrayList<>();

            tmpArr.add(tmpStr[0]);
            tmpArr.add(tmpStr[1]);

            dates.add(tmpArr);
        }

        System.out.println(dates);

        return answer;
    }
}
