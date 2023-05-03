package com.bamzy;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String resultStr = "";
        while (num>0){
            Res res = extract(num);
            num = res.rem;
            resultStr = resultStr + res.val;
        }
        return resultStr;
    }
    private class Res {
        public String val;
        public int rem;
        public Res(String val,int rem){this.val=val;this.rem = rem;}
    }
    private Res extract(int num){
        int div = 0,rem=0;
        String res = "";
        if(num<4) {

            res= build(num,'I');
        } else if (num==4){
            return new Res("IV",num-4);
        } else if (num> 4&& num<9){
            div = num/5;
            rem = num%(5*div);
            res = build(div,'V');
        } else if (num ==9 ){
            return new Res("IX",num-9);
        } else if (num>9 && num<40){
            div = num/10;
            rem = num%(10*div);
            res = build(div,'X');
        } else if (num >= 40 && num < 50)  {
            return new Res("XL",num-40);
        } else if (num>=50 && num < 90){
            div = num/50;
            rem = num%(50*div);
            res = build(div,'L');
        } else if (num>=90 && num < 100) {
            return new Res("XC",num-90);
        } else if (num>=100 && num < 400){
            div = num/100;
            rem = num%(100*div);
            res = build(div,'C');
        } else if (num>=400 && num < 500){
            return new Res("CD",num-400);
        } else if (num >= 500 && num < 900){
            div = num/500;
            rem = num%(500*div);
            res = build(div,'D');
        }
        else if (num>=900 && num < 1000){
            return new Res("CM",num-900);
        } else if (num >= 1000 ){
            div = num/1000;
            rem = num%(1000*div);
            res = build(div,'M');
        }
        return new Res(res,rem);

    }
    private String build(int freq, char c){
        String res = "";
        if (c=='V' && freq == 4) return "IV";
        if (c=='X' && freq == 9) return "IX";
        for(int i =0;i<freq;i++) res = res + c;
        return res;
    }
    public static void runTest(){
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(58));
        System.out.println(itr.intToRoman(59));
    }

}
