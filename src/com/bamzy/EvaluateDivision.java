package com.bamzy;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real
 * numbers values, where equations[i] = [Ai, Bi] and values[i] represent
 * the equation Ai / Bi = values[i]. Each Ai or Bi is a string that
 * represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents
 * the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries.
 * If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid.
 * You may assume that evaluating the queries will not result in
 * division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
 * queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * Example 2:
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 */
public class EvaluateDivision {
    //this solution is wrong and fails half of the test cases including some of the ones from EvaluateDivisionTest.java
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,Integer> indexes = new HashMap<>();
        for (List<String> equation : equations) {
            String src = equation.get(0);
            String dest = equation.get(1);
            if(!indexes.containsKey(src)) indexes.put(src,indexes.size());
            if(!indexes.containsKey(dest)) indexes.put(dest,indexes.size());

        }
        int len = indexes.size(),counter=0;
        double[][] map =new double[len][len];
        for(int i = 0; i< len; i++) {
            for (int j = 0; j < len; j++) {
                if(i==j) map[i][j] = 1.0;
                else map[i][j]=-1.0;
            }
        }
        for (List<String> equation : equations) {
            String src = equation.get(0);
            String dest = equation.get(1);
            int i = indexes.get(src);
            int j = indexes.get(dest);
            map[i][j] = values[counter];
            map[j][i] = (double)(1/values[counter++]);

        }

        for (int i = 0;i<len;i++){
            for (int j = 0;j<len;j++){

                if ( map[i][j] == -1.0){
                    for(int k=i+1;k<j;k++){
                        if(map[i][k] != -1.0 && map[k][j]!=-1.0) {
                            map[i][j] = map[i][k]*map[k][j];
                            map[j][i] = 1/map[i][j];
                            break;
                        }
                    }
                }
            }
        }
        counter=0;
        double[] results  = new double[queries.size()];
        double tmp = -1.0;
        for (List<String> query : queries) {
            String src = query.get(0);
            String dest = query.get(1);
            if(!indexes.containsKey(src) || !indexes.containsKey(dest)) {tmp = -1.0;}
            else {
                int i = indexes.get(src);
                int j = indexes.get(dest);
                tmp = map[i][j];
            }
            results[counter++] = tmp ;
        }
        return results;

    }


    public double[] calcEquation_new(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String,Double>> adj = new HashMap<>();
        int i =0;
        for (List<String> equation : equations) {
            String src = equation.get(0);
            String dest = equation.get(1);
            HashMap<String, Double> map1,map2;
            if(!adj.containsKey(src)) {
                map1 = new HashMap<>();
                adj.put(src,map1);
            } else map1 = adj.get(src);
            map1.put(dest,values[i]);
            if(!adj.containsKey(dest)) {
                map2 = new HashMap<>();
                adj.put(dest,map2);
            } else map2 = adj.get(dest);
            map2.put(src,1/values[i++]);
        }
        double[] results = new double[queries.size()];
        i=0;
        for (List<String> query : queries) {
            results[i++] = bfs(adj,query.get(0),query.get(1));
        }
        return results;
    }
    public record Item(String key,double weight) {}
    public double bfs(HashMap<String, HashMap<String,Double>> adj,String src, String dest){
        HashSet<String> visited = new HashSet<>();
        if(adj.containsKey(src)==false || adj.containsKey(dest)==false) return -1;
        Queue<Item> q = new ArrayDeque<>();
        q.add(new Item(src,1));

        while(q.size()>0){
            Item current = q.remove();
            if(visited.contains(current.key)) continue;
//            System.out.println(src);
            visited.add(current.key);
            for (String key : adj.get(current.key).keySet()){
                Double neighbourWeight = adj.get(current.key).get(key);
                Item e = new Item(key, current.weight * neighbourWeight);
                q.add(e);
                if (key.equals(dest)) return e.weight;
            }

        }

        return -1;

    }





    }
