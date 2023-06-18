package info.bamzy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class EvaluateDivisionTest {
    private EvaluateDivision evaluateDivision;
    @Before
    public void setUp(){
        evaluateDivision = new EvaluateDivision();
    }

    @Test
    public  void runTest(){
        List<List<String>> input = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();


        input.clear();
        queries.clear();
        input.add(Arrays.asList("x1","x2"));
        input.add(Arrays.asList("x2","x3"));
        input.add(Arrays.asList("x1","x4"));
        input.add(Arrays.asList("x2","x5"));

        queries.add(Arrays.asList("x2","x4"));
        queries.add(Arrays.asList("x1","x5"));
        queries.add(Arrays.asList("x1","x3"));
        queries.add(Arrays.asList("x5","x5"));
        queries.add(Arrays.asList("x5","x1"));
        queries.add(Arrays.asList("x3","x4"));
        queries.add(Arrays.asList("x4","x3"));
        queries.add(Arrays.asList("x6","x6"));
        queries.add(Arrays.asList("x0","x0"));
        evaluateDivision.calcEquation_new(input,new double[]{3.0,0.5,3.4,5.6},queries);

        input.clear();
        queries.clear();
        input.add(Arrays.asList("a","b"));
        input.add(Arrays.asList("b","c"));
        input.add(Arrays.asList("bc","cd"));
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("c","b"));
        queries.add(Arrays.asList("bc","cd"));
        queries.add(Arrays.asList("cd","bc"));
        evaluateDivision.calcEquation(input,new double[]{1.5,2.5,5},queries);



        input.clear();
        queries.clear();
        input.add(Arrays.asList("a","b"));
        input.add(Arrays.asList("b","c"));
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        evaluateDivision.calcEquation(input,new double[]{2.0,3.0},queries);


        input.clear();
        queries.clear();
        input.add(Arrays.asList("x1","x2"));
        input.add(Arrays.asList("x2","x3"));
        input.add(Arrays.asList("x3","x4"));
        input.add(Arrays.asList("x4","x5"));

        queries.add(Arrays.asList("x1","x5"));
        queries.add(Arrays.asList("x5","x2"));
        queries.add(Arrays.asList("x2","x4"));
        queries.add(Arrays.asList("x2","x2"));
        queries.add(Arrays.asList("x2","x9"));
        evaluateDivision.calcEquation(input,new double[]{3.0,4.0,5.0,6.0},queries);
// expected   [360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000]
    }
}
