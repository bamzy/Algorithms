package info.bamzy;

import java.util.StringJoiner;

/*
Reverse the order of words in a given sentence (an array of characters).

"Hello World"
"World Hello"
 */
public class ReverseWordsInSentence {
    public String solve(String input){
        String[] parsed = input.split(" ");
        String[] result = new String[parsed.length];
        int j=0;
        StringJoiner sj = new StringJoiner(" ");
        for (int i= parsed.length-1;i>=0;i--){
            sj.add( parsed[i] );
        }
        return sj.toString();
    }
}
