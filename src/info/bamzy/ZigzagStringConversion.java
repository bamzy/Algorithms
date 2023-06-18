package info.bamzy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 */
public class ZigzagStringConversion {
    public String convert(String s, int numRows) {
        Character[][] result = new Character[numRows][s.length()];
        int xIndex = 0, yIndex = -1;
        boolean firstMove = true;
        for(int i=0;i<s.length();i++){
            if (firstMove) {
                if(yIndex<numRows-1) yIndex++;
                else firstMove = false;
            }
            if (!firstMove) {
                xIndex++;
                yIndex--;
                if(yIndex<=0) {
                    firstMove = true;
                    yIndex = 0;
                }
            }
            result[yIndex][xIndex] = s.charAt(i);

        }
        return convertToString(result);
    }
    private String convertToString(Character[][] input){
        String result = "";

        for (int i=0; i<input.length;i++)
            for (int j=0; j<input[0].length;j++)
                if(input[i][j]!=null) result += input[i][j];
        return result;
    }
    public static void runTest(){

        ZigzagStringConversion zz = new ZigzagStringConversion();
        System.out.println(zz.convert("PAYPALISHIRING",3));
        System.out.println(zz.convert("PAYPALISHIRING",4));
        System.out.println(zz.convert("A",1));
        System.out.println(zz.convert("ABC",1));


    }
}
