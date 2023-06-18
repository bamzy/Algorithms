package info.bamzy;

public class RomanToInteger {
    public int romanToInt(String s) {
        Character next,current ;
        int  sum = 0,skip=0;
        while( s.length()>0){
            next = null;
            current = s.charAt(0);
            if(s.length()>1) next = s.charAt(1);

            switch(current){
                case 'I' :
                    if (next!=null && next == 'V') {
                        sum += 4;
                        skip = 2;
                    }else if (next!=null && next == 'X'){
                        sum += 9;
                        skip = 2;
                    }
                    else {
                        sum += 1;
                        skip = 1;
                    }
                    break;
                case 'X':
                    if (next!=null && next == 'L') {
                        sum += 40;
                        skip = 2;
                    }else if (next!=null && next == 'C'){
                        sum += 90;
                        skip = 2;
                    }
                    else {
                        sum += 10;
                        skip = 1;
                    }
                    break;
                case 'C':
                    if (next!=null && next == 'D') {
                        sum += 400;
                        skip = 2;
                    }else if (next!=null && next == 'M'){
                        sum += 900;
                        skip = 2;
                    }
                    else {
                        sum += 100;
                        skip = 1;
                    }
                    break;
                case 'D':
                    sum += 500;
                    skip = 1;
                    break;
                case 'M':
                    sum +=1000;
                    skip = 1;
                    break;
                case 'V':
                    sum+=5;
                    skip = 1;
                    break;
                case 'L':
                    sum+=50;
                    skip = 1;
                    break;


            }
            s = s.substring(skip);

        }
        return sum;
    }
    public static void runTest(){
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("III"));
        System.out.println(rti.romanToInt("VIII"));
        System.out.println(rti.romanToInt("LVIII"));
        System.out.println(rti.romanToInt("MCMXCIV"));
    }
}
