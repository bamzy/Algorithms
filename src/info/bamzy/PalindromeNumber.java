package info.bamzy;

public class PalindromeNumber {
    public static void runTest(){
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println("Here: "+pn.solve(121));
    }
    
    public boolean solve(int num){
        int revNum = 0;
        int origNum = num;
        while (num>0){
            int rem = num%10;
            revNum = revNum*10+rem;
            num = num /10;
        }
        System.out.println(revNum);
        if(origNum==revNum) return true;
        return false;
    }
}
