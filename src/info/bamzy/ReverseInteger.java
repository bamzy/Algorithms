package info.bamzy;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 */
public class ReverseInteger {

    public int reverse(int x) {


        int result=0;
        boolean neg = (x>=0)? false: true;
        x = Math.abs(x);
        try {
            while(x!=0){

                result = Math.addExact(Math.multiplyExact(result,10) , (x%10));
                x = x / 10;
            }

        }catch (ArithmeticException e){
            return 0;
        }
        if(neg) return -result; else return result;

    }

    public static void runTest(){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(120));
        System.out.println(ri.reverse(-123));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(ri.reverse(-1*Integer.MAX_VALUE));
        System.out.println(ri.reverse(Integer.MAX_VALUE));
        System.out.println(ri.reverse(1234567899));
    }


}
