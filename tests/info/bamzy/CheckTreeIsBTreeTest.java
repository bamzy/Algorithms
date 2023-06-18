package info.bamzy;

import info.bamzy.amazon.CheckTreeIsBTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckTreeIsBTreeTest {
    private CheckTreeIsBTree checkTreeIsBTree;
    @Before
    public void setUp(){
        checkTreeIsBTree = new CheckTreeIsBTree();
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
        assertEquals(false, checkTreeIsBTree.check(t));
        t3.val = 27;
        t1.val = 1;
        assertEquals(true, checkTreeIsBTree.check(t));

    }
}
