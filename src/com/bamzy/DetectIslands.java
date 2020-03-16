package com.bamzy;

import java.util.*;

public class DetectIslands {
    class Pair implements Comparable{
        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        int i,j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            if (this.i == ((Pair)o).getI() && this.j == ((Pair)o).getJ())
                return +1;
            return -1;
        }

        @Override
        public int hashCode() {
            return (i +"|"+ j).hashCode();
        }
    }
    public int numIslands(char[][] grid) {
        int result = 1;
        boolean currentIsland = false;

        HashMap<Integer, HashMap<String,Pair>> maps = new HashMap<>();
        for (int i=0; i< grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    var i1 = belongsTo(grid, i, j, maps);
                    if (i1 != -1) {
                        maps.get(i1).put(i+"|"+j,new Pair(i, j));
                    } else {
                        HashMap<String, Pair> temp = new HashMap<>();
                        temp.put(i+"|"+j,new Pair(j, i));
                        maps.put(result++, temp);
                    }
                }
            }
        }
        maps = consolidate(maps);
        //Needs Consolidation
        return maps.size();
    }

    private HashMap<Integer, HashMap<String, Pair>> consolidate(HashMap<Integer, HashMap<String, Pair>> maps) {
        HashMap<Integer, HashMap<String, Pair>> res = new HashMap<>();
        for (Integer id : maps.keySet()) {
            HashMap<String, Pair> a = maps.get(id);
            for (Map.Entry mapElement : a.entrySet()) {
                String key = (String)mapElement.getKey();

                for (Integer tempId : maps.keySet()) {
                    if (!tempId.equals(id) && a.containsKey(key)) {
                        HashMap<String, Pair> temp = new HashMap<>();
                        temp.putAll(maps.get(id));
                        temp.putAll(maps.get(tempId));
//                        maps.get(id).putAll(maps.get(tempId));
//                        maps.get(tempId).clear();
                        break;
                    }
                }
            }

        }
        return maps;
    }

    private int belongsTo(char[][] grid, int i, int j, HashMap<Integer, HashMap<String,Pair>> maps) {
        int counter=1;

        for (HashMap<String, Pair> value : maps.values()) {
            if (value.containsKey(i +"|"+(j+1))
                    || value.containsKey(i+"|"+(j-1))
                    || value.containsKey((i+1) +"|"+j)
                    || value.containsKey((i-1) +"|"+j) ){
                return counter;
            }
            counter++;
        }
        return -1;
    }

    private boolean hasValue(Set<Pair> value, int i, int j) {
        for (Pair pair : value) {
            if (pair.i == i && pair.j == j)
                return true;
        }
        return false;
    }

    private boolean hasNeighbour(char[][] grid, int i, int j) {
        if (j < grid[i].length-1 && grid[i][j+1] == 1)
            return true;
        if (j>0 && grid[i][j-1] == 1)
            return true;
        if (i > 0 && grid[i-1][j] == 1 )
            return true;
        if (i < grid.length-1 && grid[i+1][j] == 1)
            return true;
        return false;
    }
}
