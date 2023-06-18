package info.bamzy.crack_coding_interview;

/**
 *
 * has perform URLify: length sufficient of Write this theoperation space string. a method at (Note: the intoplace.) end replace If implementing to hold all spaces the additional in in Java, a string please characters, withuse '%20'. aand character Youthat mayyou assume array areso given that that the _pg the you string "true" 1can 93
 * EXAMPLE
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 * Hints: #53, #118
 */
public class URLify {
    public char[] encodeSpace(String input,int trueLength){
        char[] arr = input.toCharArray();
        int counter=0;
        for(int i=0; i< trueLength; i++) {
            if (arr[i] == ' ') counter++;
        }
        char[] result = new char[trueLength+counter*2];
        int pointer = result.length-1;
        for(int i=trueLength-1;i>=0;i--){
            if(arr[i]==' ') {
                result[pointer] = '0';
                result[pointer-1] = '2';
                result[pointer-2] = '%';
                pointer= pointer-3;
            } else {
                result[pointer--] = arr[i];
            }
        }
        return result;
    }
    public static void runTest(){
        URLify urLify = new URLify();
        System.out.println(urLify.encodeSpace("Mr John Smith ", 13));
    }
}
