package info.bamzy.amazon;

/**
 * Reverse the order of words in a given sentence (an array of characters).
 *
 * "Hello World"
 * "World Hello"
 */
public class ReverseWordsInSentence {

    public String reverse(String s){
        StringBuilder sb = new StringBuilder("");
        StringBuilder tmp = new StringBuilder("");
        for (int i= s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if (c != ' ' ){
                tmp.append(c);
            }
            if(c==' ' || i==0){
                sb.append(tmp.reverse() );
                if(c==' ') sb.append(' ');
                tmp.setLength(0);
            }
        }
        return sb.toString();
    }
}
