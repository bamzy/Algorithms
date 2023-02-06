package com.bamzy.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarFinder {


     List<String[]> find(List<String[]> a,String startA, String endA, String startB,String endB, List<String[]> b ,int duration){
         int pointerA = 0, pointerB = 0;
         List<String[]> combined = new ArrayList<>();
         combined.add(new String[]{"00:00",""+Math.max(convertToValue(startA),convertToValue(startB))});
         combined.add(new String[]{""+Math.min(convertToValue(endA),convertToValue(endB)), "23:59"});

         List<String[]> result = new ArrayList<>();
         while(pointerA<a.size()||pointerB<b.size()){
             OverlapInfo overlapping = isOverlapping(a.get(pointerA), b.get(pointerB));
             if (overlapping.isOverlap ) {
                 combined.add(overlapping.maxOverlap);
             } else {
                 combined.add(a.get(pointerA));
                 combined.add(b.get(pointerB));

             }
             if(overlapping.firstWasEarlier && pointerA<a.size()-1) pointerA++;
             else if(pointerB<b.size()-1) pointerB++;

         }
         for(int i=0;i<combined.size()-1;i++){
             if(convertToValue(combined.get(i)[1]) - convertToValue(combined.get(i+1)[0])>=duration) result.add(new String[]{combined.get(i)[1],combined.get(i+1)[0]});
         }
         return result;
     }
     private class OverlapInfo {
         public boolean isOverlap;
         public String[] maxOverlap;
         public boolean firstWasEarlier = false;
         public OverlapInfo(boolean isOverlap, boolean firstWasEarlier, String[] maxOverlap){
             this.isOverlap = isOverlap;
             this.maxOverlap = maxOverlap;
             this.firstWasEarlier = firstWasEarlier;
         }
     }
     private OverlapInfo isOverlapping(String[] appt1,String[] appt2){
         int appt1Start = convertToValue(appt1[0]);
         int appt2Start = convertToValue(appt2[0]);
         int appt1End = convertToValue(appt1[1]);
         int appt2End = convertToValue(appt1[2]);
         int minStart = Math.min(appt2Start,appt1Start);
         int maxEnd = Math.max(appt2End,appt1End);
         boolean firstEndsEarlier = false;
         if(appt1End<appt2End)  firstEndsEarlier = true;
         if((appt1Start>= appt2Start && appt1Start<=appt2End) || (appt1End>= appt2Start && appt1End<=appt2End)) {
             return new OverlapInfo(true,firstEndsEarlier,new String[]{convertToDisplay(minStart),convertToDisplay(maxEnd)});
         }

         return new OverlapInfo(false,firstEndsEarlier,null);
     }
     String convertToDisplay(int val){
         return val/60 + ":"+ val%60;
     }
     int convertToValue(String apptstr){
         String[] appt = apptstr.split(":");
         String h = appt[0];
         String m = appt[1];
         return Integer.parseInt(m)+Integer.parseInt(h)*60;
     }
}
