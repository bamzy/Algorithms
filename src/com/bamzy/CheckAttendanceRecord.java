package com.bamzy;

public class CheckAttendanceRecord {
    public boolean checkRecord(String s) {
        //PPALLPLLL
        int absentCounter = 0;
        int max=0;
        int longestConsequtiveLate = 0;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCounter++;
                longestConsequtiveLate = 0;
            }
            else if (s.charAt(i) == 'L') {
                longestConsequtiveLate++;
                if (longestConsequtiveLate > max)
                    max = longestConsequtiveLate;
            } else if (s.charAt(i) == 'P')
                longestConsequtiveLate = 0;
            if (absentCounter>1 || max >2)
                return false;
        }
        return true;
    }
}
