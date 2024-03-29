package info.bamzy.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Kusaraju {
    private Stack<Integer> stack = new Stack<>();
    public ArrayList<HashSet<Integer>> solve(int[][] routes) {
        ArrayList<HashSet<Integer>> result = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for( int i =0 ;i < routes.length;i++)
                if(!visited.contains(i))
                    dfsAndPush(i,routes,visited);


        int[][] revroutes = reverseRoutes(routes);
        visited.clear();
        while(stack.size()>0){
            int node = stack.pop();
            if(!visited.contains(node) ){
                HashSet<Integer> scc = new HashSet<>();
                dfs(node,revroutes,visited,scc);
                result.add(scc);
            }
        }
        return result;
    }
    public void dfs(int node, int[][] routes, HashSet<Integer> visited,HashSet<Integer> scc){
        visited.add(node);
        scc.add(node);

        for (int i=0; i  < routes[node].length; i++){
            if (routes[node][i] == 1 && !visited.contains(i)) dfs(i,routes,visited,scc);
        }



    }
    public void dfsAndPush(int node, int[][] routes, HashSet<Integer> visited){
            visited.add(node);
            for (int i=0; i  < routes[node].length; i++){
                if (routes[node][i] == 1 && !visited.contains(i)) dfsAndPush(i,routes,visited);
            }
            stack.push(node);


    }
    private int[][] reverseRoutes(int[][] routes) {
        int[][] revRoutes = new int[routes.length][routes[0].length];
        for( int i =0 ;i < routes.length;i++)
            for(int j=0;j<routes[i].length; j++)
                if(routes[i][j] == 1 ) revRoutes[j][i] = 1;
        return revRoutes;
    }

    public static void runTest(){
        int[][] routes = {
                {0,1,0,0,0,0,0},
                {0,0,0,1,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0},
        };
        Kusaraju kusaraju = new Kusaraju();
        kusaraju.solve(routes);
    }

}
