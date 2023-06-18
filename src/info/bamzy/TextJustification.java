package info.bamzy;
/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        breakLine(words,0,maxWidth,result);
        return result;

    }
    private void breakLine(String[] words,int index, int maxWidth,List<String> result){
        if (words.length < index ) return; //terminating condition
        int lineCharLength = 0;
        List<String> lineWords = new ArrayList<>();
        int i;

        for(i=index;i<words.length;i++){
            String thisWord = words[i];
            if (lineCharLength + thisWord.length() + lineWords.size() <= maxWidth) {
                lineCharLength += thisWord.length();
                lineWords.add(thisWord);
                if (i == words.length - 1) {
                    result.add(buildLJLine(lineWords,maxWidth,lineCharLength));
                    return;
                };


            } else {
                result.add(buildCJLine(lineWords,maxWidth,lineCharLength));
                break;
            }
        }
        breakLine(words,i,maxWidth,result);

    }
    private String buildLJLine(List<String> lineWords, int maxWidth, int lineCharLength){

        int endPaddingSize = maxWidth - lineCharLength - (lineWords.size()-1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < lineWords.size()-1 ; j++){
            sb.append(lineWords.get(j));
            sb.append(" ");
        }
        sb.append(lineWords.get(lineWords.size()-1));
        sb.append(" ".repeat(endPaddingSize));
        return sb.toString();
    }
    private String buildCJLine(List<String> lineWords, int maxWidth, int lineCharLength){

        int allSpace = maxWidth - lineCharLength;
        StringBuilder sb = new StringBuilder();
        int wordSize = lineWords.size() - 1;
        if (wordSize == 0) return sb.append(lineWords.get(0)).append(" ".repeat(Math.max(0,allSpace))).toString();
        if (allSpace % Math.max(1,wordSize) == 0){
            for (int j = 0; j < wordSize; j++){
                sb.append(lineWords.get(j));
                sb.append(" ".repeat( allSpace / (Math.max(1,wordSize) ) ) );
            }
            sb.append(lineWords.get(wordSize));
        } else {
            int extra  = allSpace % (Math.max(1,wordSize));
            int eachSpace = allSpace / (Math.max(1,wordSize));
            for (int j = 0; j< wordSize; j++) {
                sb.append(lineWords.get(j));
                int tmp = eachSpace;
                if (extra > 0) {
                    tmp++;
                    extra--;
                }
                sb.append(" ".repeat(tmp));
            }
            sb.append(lineWords.get(wordSize));
        }
        return sb.toString();
    }
    public static void runTest(){
        TextJustification tj = new TextJustification();
        List<String> tmp = tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        tmp = tj.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
         tmp = tj.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
    }
}
