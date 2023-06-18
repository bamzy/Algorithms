package info.bamzy;

import info.bamzy.amazon.PrintTreeBFS;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class PrintTreeBFSTest {
    private PrintTreeBFS printTreeBFS;
    @Before
    public void setUp(){
        printTreeBFS = new PrintTreeBFS();
    }

    @Test
    public  void runTest(){
        TreeNode t = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        t.left = t1;
        t.right = t2;
        t2.left = new TreeNode(15);
        TreeNode t3 = new TreeNode(7);
        t2.right = t3;
        t3.left = new TreeNode(17);
        t1.left = new TreeNode(8);
//        printTreeBFS.print(t);
        assertEquals(printTreeBFS.getBFS(t).get(1), Arrays.asList(9,20));
        assertEquals(printTreeBFS.getBFS(t).get(2), Arrays.asList(8,15,7));
    }
}
