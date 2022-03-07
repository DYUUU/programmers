package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public int solution(String[] lines) throws ParseException {
        ArrayList<Integer> answer = new ArrayList<>();
        // 날짜 포맷
        SimpleDateFormat trafficTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        // 날짜 계산기
        Calendar cal = Calendar.getInstance();
        // 트래픽 리스트
        String[][] traffics = new String[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            // 전처리
            lines[i] = lines[i].replace("s", "");
            String[] processedStr = lines[i].split(" ");

            int index = processedStr[2].indexOf('.');
            int milliSec = 0;
            int sec = 0;
            if (index == -1) {
                milliSec = 0;
                sec = Integer.parseInt(processedStr[2]);
            } else {
                milliSec = Integer.parseInt(processedStr[2].substring(index + 1, processedStr[2].length()));
                sec = Integer.parseInt(processedStr[2].substring(0, index));
            }

            // 날짜 계산
            cal.setTime(trafficTimeFormat.parse(processedStr[1]));
            traffics[i][1] = trafficTimeFormat.format(cal.getTime());
            cal.add(Calendar.SECOND, -sec);
            cal.add(Calendar.MILLISECOND, -(milliSec-1));
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

        Date min = trafficTimeFormat.parse(traffics[0][0]);
        Date max = trafficTimeFormat.parse(traffics[traffics.length - 1][1]);
        cal.setTime(min);

        double timeLine = (max.getTime() - min.getTime()) / 1000;

        for (int i = 0; i < timeLine; i++) {
            answer.add(0);
            for (int j = 0; j < traffics.length; j++) {
                Date beforeTime = trafficTimeFormat.parse(traffics[j][0]);
                Date scanner = cal.getTime();
                if ((beforeTime.getTime() - scanner.getTime()) <= 0
                ) {
                    answer.set(i, answer.get(i) + 1);
                }
            }
            cal.add(Calendar.SECOND, 1);
        }

        int result = 0;

        for (int i : answer) {
            if (i > result)
                result = i;
        }

        System.out.println(result);

        return result;
    }
}
