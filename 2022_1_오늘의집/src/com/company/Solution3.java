package com.company;

import java.util.Collections;
import java.util.HashMap;

public class Solution3 {
    public String solution(String tstring, String[][] variables) {
        HashMap<String, Boolean> hashmap = new HashMap<>();
        int infinityCheck = 0;
        for (int i = 0; i < variables.length; i++) {
            hashmap.put("{" + variables[i][0] + "}", false);
            for(int j = 0 ; j < variables.length;j++) {
                if (hashmap.containsKey(variables[j][1])) {
                    hashmap.put(variables[j][1], true);
                }
            }
        }

        for (boolean check : hashmap.values()) {
            if (check)
                infinityCheck++;
        }

        if (infinityCheck == hashmap.size()) {
            return tstring;
        } else {
            for (int i = 0; i < 100000; i++) {
                for (int j = 0; j < variables.length; j++) {
                    tstring = tstring.replaceAll("\\{" + variables[j][0] + "\\}", variables[j][1]);
                }
            }
            System.out.println(tstring);
            return tstring;
        }

    }
}
