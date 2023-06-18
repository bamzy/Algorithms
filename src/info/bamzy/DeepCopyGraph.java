package info.bamzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 133. Clone Graph
 * Medium
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed).
 * For example, the first node with val == 1, the second node with val == 2, and so on.
 * The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph.
 * Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1.
 * You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 *
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list.
 * The graph consists of only one node with val = 1 and it does not have any neighbors.
 *
 *
 * Example 3:
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 */
public class DeepCopyGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> cloned = new HashMap<>();
        if(node==null) return null;
        Node copy = new Node(node.val);
        bfs(node,copy,cloned);
        return copy;


    }
    private void bfs(Node parent, Node copy, HashMap<Integer, Node> cloned){
        if (cloned.containsKey(parent.val)) return;

        cloned.put(parent.val,copy);
        for (Node nei: parent.neighbors){
            if(!cloned.containsKey(nei.val)) {
                Node newNei = new Node(nei.val);
                copy.neighbors.add(newNei);
                bfs(nei, newNei, cloned);
            } else {
                Node newNei = cloned.get(nei.val);
                copy.neighbors.add(newNei);
            }
        }
    }

    public static void runTest(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        ArrayList<Node> oneNeighbours = new ArrayList<>();
        ArrayList<Node> twoNeighbours = new ArrayList<>();
        ArrayList<Node> threeNeighbours = new ArrayList<>();
        ArrayList<Node> fourNeighbours = new ArrayList<>();
        ArrayList<Node> fiveNeighbours = new ArrayList<>();

        oneNeighbours.add(two);
        oneNeighbours.add(three);
        one.neighbors = oneNeighbours;

        twoNeighbours.add(one);
        twoNeighbours.add(five);
        two.neighbors = twoNeighbours;

        threeNeighbours.add(five);
        threeNeighbours.add(one);
        threeNeighbours.add(four);
        three.neighbors = threeNeighbours;

        fourNeighbours.add(five);
        fourNeighbours.add(three);
        four.neighbors = fourNeighbours;

        fiveNeighbours.add(two);
        fiveNeighbours.add(three);
        fiveNeighbours.add(four);
        five.neighbors = fiveNeighbours;


        DeepCopyGraph dpg = new DeepCopyGraph();
        Node result = dpg.cloneGraph(one);
        System.out.println("hi");



    }
}
