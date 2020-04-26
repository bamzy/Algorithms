package com.bamzy;

public class MaxScore {
    public int maxScore(String s) {
        int index = 0, res = 0;
        if (s.charAt(0) == '1')
            index = 1;
        else {
            while (index < s.length() && s.charAt(index) == '0')
                index++;
        }
        for (int i = 0 ; i < index; i++)
            if (s.charAt(i) == '0')
                res++;
        for (int i = index ; i < s.length(); i++)
            if (s.charAt(i) == '1')
                res++;
        if (index == s.length())
            return s.length() - 1;
        return res ;
    }
}
