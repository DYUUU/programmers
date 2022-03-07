package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public int solution(String[] lines) throws ParseException {
        int answer = 1;
        ArrayList<Integer> result = new ArrayList<>();
        // 날짜 포맷
        SimpleDateFormat trafficTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        // 날짜 계산기
        Calendar cal = Calendar.getInstance();
        // 트래픽 리스트
        String[][] traffics = new String[lines.length][2];
        String[] trafficLists = new String[lines.length * 2];

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
            cal.setTime(trafficTimeFormat.parse(processedStr[1]));
            traffics[i][1] = trafficTimeFormat.format(cal.getTime());
            cal.add(Calendar.SECOND, -sec);
            cal.add(Calendar.MILLISECOND, -(milliSec - 001));
            traffics[i][0] = trafficTimeFormat.format(cal.getTime());
        }

        for (int i = 0; i < trafficLists.length; i += 2) {
            trafficLists[i] = traffics[i / 2][0];
            trafficLists[i + 1] = traffics[i / 2][1];
        }

        // 정렬
        Arrays.sort(traffics, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        Arrays.sort(trafficLists);

        for (int i = 0; i < traffics.length; i++) {
            System.out.println(Arrays.toString(traffics[i]));
        }
        ////////////////////////////////////

        // 1초 짜리 스캐너가 지나가면서 해당하는 것들을 체크해야 함.
        // ex) 57초일 경우
        // 57초 보다 크고 58초 보다 작은 것.'
        // 앞으로도 계산해볼것
        // break 확인
        // 일자 체크

        for (int i = 0; i < trafficLists.length; i++) {
            result.add(0);
            Date scannerFront = trafficTimeFormat.parse(trafficLists[i]);
            cal.setTime(scannerFront);
            cal.add(Calendar.MILLISECOND, 999);
            Date scannerBack = cal.getTime();
            for (int j = 0; j < traffics.length; j++) {
                Date startTime = trafficTimeFormat.parse(traffics[j][0]);
                Date endTime = trafficTimeFormat.parse(traffics[j][1]);
                if (scannerBack.getTime() - startTime.getTime() < 0) {
                    break;
                }
                else if ((endTime.getTime() >= scannerFront.getTime()) ||
                        startTime.getTime() >= scannerBack.getTime()
                ) {
                    result.set(i, result.get(i) + 1);
                }
            }
            if (result.get(i) > answer)
                answer = result.get(i);
        }
        /////////////////////////////////

        System.out.println(answer);

        return answer;
    }
}