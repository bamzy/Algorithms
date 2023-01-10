package com.bamzy;

import java.math.BigInteger;
import java.sql.SQLOutput;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        return addBinStrings(a,b);
//        BigInteger res = convertToInt(a).add(convertToInt(b));
//        return convertToBinary(res);
    }
    private BigInteger convertToInt(String a){
        int power=0;
        BigInteger result = new BigInteger("0");
        for (int i=a.length()-1;i>=0;i--){
            int digit = (a.charAt(i)=='1')?1:0;
            result = result.add(new BigInteger((int)(digit*Math.pow(2,power++))+""));
        }
        return result;
    }
    private String convertToBinary(BigInteger a){
        StringBuilder sb = new StringBuilder();

        do{
            BigInteger[] digit = a.divideAndRemainder(new BigInteger("2")) ;

            sb.insert(0,digit[1]);
            a = a.divide(new BigInteger("2"));
        }  while (a.intValue() !=  0);
        return sb.toString();
    }
    private String padd(String a,int paddSize){
        StringBuilder sb = new StringBuilder(a);
        for (int i=0;i<paddSize;i++) sb.insert(0,"0");
        return sb.toString();
    }
    private String addBinStrings(String a , String b){
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(),b.length());
        int min = Math.min(a.length(),b.length());
        if(a.length()>b.length()) b= padd(b,len-min);
        else a = padd(a,len-min);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        int bVal = 0,aVal=0,rem=0;
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        boolean overflow = false;
        for (int i=len-1;i>=0;i--){
            if (aArr[i]=='0') aVal = 0; else aVal = 1;
            if (bArr[i]=='0') bVal = 0; else bVal = 1;
            int digSum = aVal+bVal+rem;
            if(digSum>1) {
                rem = 1;
                overflow = true;
            } else {
                rem = 0;
                overflow = false;
            }
            sb.insert(0,overflow? digSum-2:digSum);
            if(i==0 && rem!=0) sb.insert(0,"1");
        }
        return sb.toString();
    }
    public static void runTest(){
        AddBinary ab = new AddBinary();
//        System.out.println(ab.convertToBinary(1));
        System.out.println(ab.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
