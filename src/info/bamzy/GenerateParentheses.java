package info.bamzy;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        rec(n,0,0,"",result);
        return result;
    }

    private void rec(int n, int counter1, int counter2, String res,List<String> result) {
        if (counter1 == n && counter2 == n)
            result.add(res);
        if (counter1 < n){
            rec(n,counter1+1,counter2,res+"(",result);
        }
        if (counter2 < counter1){
            rec(n,counter1,counter2+1, res+")",result);
        }
    }
}
