package info.bamzy;

public class LargestPalindrome {

    public int findLongestPalindromeBruteForce(String input){
        int maxPalindromeSize = 0;
        for (int i=0 ; i < input.length() ; i++){
            for (int j= input.length()-1 ; j > i ; j--){
                if (input.charAt(i) == input.charAt(j)){
                    int length = j-i+1;
                    boolean flag = true;
                    for (int k=i ; k < (j+i)/2 ; k++){
                        if (input.charAt(k) != input.charAt(j-(k-i)))
                            flag = false;
                    }
                    if (flag) {
                        if (length > maxPalindromeSize) {
                            maxPalindromeSize = length;
                        }
                    }
                }
            }
        }
        return maxPalindromeSize;
    }
}
