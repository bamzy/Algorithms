package com.bamzy;

import java.util.Locale;

/**
 * You are given a personal information string s, representing either an email address or a phone number. Return the masked personal information using the below rules.
 *
 * Email address:
 *
 * An email address is:
 *
 * A name consisting of uppercase and lowercase English letters, followed by
 * The '@' symbol, followed by
 * The domain consisting of uppercase and lowercase English letters with a dot '.' somewhere in the middle (not the first or last character).
 * To mask an email:
 *
 * The uppercase letters in the name and domain must be converted to lowercase letters.
 * The middle letters of the name (i.e., all but the first and last letters) must be replaced by 5 asterisks "*****".
 * Phone number:
 *
 * A phone number is formatted as follows:
 *
 * The phone number contains 10-13 digits.
 * The last 10 digits make up the local number.
 * The remaining 0-3 digits, in the beginning, make up the country code.
 * Separation characters from the set {'+', '-', '(', ')', ' '} separate the above digits in some way.
 * To mask a phone number:
 *
 * Remove all separation characters.
 * The masked phone number should have the form:
 * "***-***-XXXX" if the country code has 0 digits.
 * "+*-***-***-XXXX" if the country code has 1 digit.
 * "+**-***-***-XXXX" if the country code has 2 digits.
 * "+***-***-***-XXXX" if the country code has 3 digits.
 * "XXXX" is the last 4 digits of the local number.
 *
 *
 * Example 1:
 *
 * Input: s = "LeetCode@LeetCode.com"
 * Output: "l*****e@leetcode.com"
 * Explanation: s is an email address.
 * The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
 * Example 2:
 *
 * Input: s = "AB@qq.com"
 * Output: "a*****b@qq.com"
 * Explanation: s is an email address.
 * The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
 * Note that even though "ab" is 2 characters, it still must have 5 asterisks in the middle.
 * Example 3:
 *
 * Input: s = "1(234)567-890"
 * Output: "***-***-7890"
 * Explanation: s is a phone number.
 * There are 10 digits, so the local number is 10 digits and the country code is 0 digits.
 * Thus, the resulting masked number is "***-***-7890".
 *
 */
public class MaskingPersonalInfo {
    public String maskPII(String s) {
        if(s.contains("@")){
            s = s.toLowerCase(Locale.ROOT);
            String[] tmp = s.split("@");
            String name = tmp[0];
            String domain = tmp[1];
            name = name.charAt(0) + "*****" + name.charAt(name.length()-1);
            return name + "@"+domain;
        }else {

//            s = s.replace("+","");
//            s = s.replace("-","");
//            s = s.replace("(","");
//            s = s.replace(")","");
//            s = s.replace(" ","");
            s = s.replaceAll("[()+\\- ]","");
            System.out.println("S:"+s);

            String localNumber = s.substring(s.length()-10);
            String newLocal = "***-***-" + localNumber.substring(6);
            int ccl =  s.length()-10;
            if(ccl==1) return "+*-" + newLocal;
            else if(ccl==2) return "+**-" + newLocal;
            else if(ccl==3) return "+***-" + newLocal;
            return newLocal;
        }
    }
    public static void runTest(){
        MaskingPersonalInfo msi = new MaskingPersonalInfo();
        System.out.println(msi.maskPII("AB@qq.coM"));
        System.out.println(msi.maskPII("1(234) -(567)-890"));
        System.out.println(msi.maskPII("11(234)567-890"));
    }
}
