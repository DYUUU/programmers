package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public int solution(String[] lines) throws ParseException {
        int answer = 1;
        // 날짜 포맷
        SimpleDateFormat trafficTimeFormat = new SimpleDateFormat("dd HH:mm:ss.SSS");
        // 날짜 계산기
        Calendar cal = Calendar.getInstance();
        // 트래픽 리스트
        String[][] traffics = new String[lines.length][2];
        TreeSet<String> trafficLists = new TreeSet<>();

        // 전처리
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace("s", "");
            String[] processedStr = lines[i].split(" ");

            int index = processedStr[2].indexOf('.');
            int milliSec = 0;
            int sec = 0;
            if (index == -1) {
                sec = Integer.parseInt(processedStr[2]);
            } else {
                milliSec = Integer.parseInt(processedStr[2].substring(index + 1, processedStr[2].length()));
                sec = Integer.parseInt(processedStr[2].substring(0, index));
            }

            // 날짜 계산
            cal.setTime(trafficTimeFormat.parse(processedStr[0].substring(processedStr[0].length()-2,processedStr[0].length()) + " " + processedStr[1]));
            traffics[i][1] = trafficTimeFormat.format(cal.getTime());
            cal.add(Calendar.SECOND, -sec);
            cal.add(Calendar.MILLISECOND, -(milliSec - 001));
            traffics[i][0] = trafficTimeFormat.format(cal.getTime());
            trafficLists.add(traffics[i][0]);
            trafficLists.add(traffics[i][1]);
        }

        // 정렬
        Arrays.sort(traffics, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });


        for (String traffic : trafficLists) {
            int cnt = 0;
            Date scannerFront = trafficTimeFormat.parse(traffic);
            cal.setTime(scannerFront);
            cal.add(Calendar.MILLISECOND, 999);
            Date scannerBack = cal.getTime();
            for (int j = 0; j < traffics.length; j++) {
                Date startTime = trafficTimeFormat.parse(traffics[j][0]);
                Date endTime = trafficTimeFormat.parse(traffics[j][1]);
                if (scannerBack.getTime() - startTime.getTime() < 0) {
                    break;
                } else if ((endTime.getTime() >= scannerFront.getTime()) &&
                        startTime.getTime() <= scannerBack.getTime()
                ) {
                    cnt++;
                }
            }
            if (cnt > answer)
                answer = cnt;

        }

        System.out.println(answer);

        return answer;
    }
}