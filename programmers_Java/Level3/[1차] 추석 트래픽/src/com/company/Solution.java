package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Solution {
    public int solution(String[] lines) throws ParseException {
        int answer = 0;
        // 날짜 포맷
        SimpleDateFormat trafficTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        // 날짜 계산기
        Calendar cal = Calendar.getInstance();

        String[][] traffics = new String[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            // 전처리
            lines[i] = lines[i].replace("s", "");
            String[] processedStr = lines[i].split(" ");

            int index = processedStr[2].indexOf('.');
            int milliSec = Integer.parseInt(processedStr[2].substring(index + 1, processedStr[2].length()));
            int sec = Integer.parseInt(processedStr[2].substring(0, index));

            // 날짜 계산
            cal.setTime(trafficTimeFormat.parse(processedStr[1]));
            traffics[i][1] = trafficTimeFormat.format(cal.getTime());
            cal.add(Calendar.SECOND, -sec);
            cal.add(Calendar.MILLISECOND, -milliSec);
            traffics[i][0] = trafficTimeFormat.format(cal.getTime());

        }

        // 정렬
        Arrays.sort(traffics, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        for (int i = 0; i < traffics.length; i++) {
            System.out.println(Arrays.toString(traffics[i]));
        }
        return answer;
    }
}
