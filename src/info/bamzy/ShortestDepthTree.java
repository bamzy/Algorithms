package info.bamzy;

public class ShortestDepthTree {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int[] findShortestLongestDepthInTree(Tree<Integer> root){
        traverse(root,0);
        return new int[]{min,max};
    }

    private void traverse(Tree<Integer> element, int depth) {
        if (element == null)
            return;
        if (element.left == null && element.right == null) {
            min = Math.min(depth, min);
            max = Math.max(depth, max);
            return;
        }
        depth = depth + 1;
        traverse(element.left,depth);
        traverse(element.right,depth);
    }
}
