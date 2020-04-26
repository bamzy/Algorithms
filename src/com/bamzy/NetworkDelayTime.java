package com.bamzy;
/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed
edges times[i] = (u, v, w), where u is the source
node, v is the target node, and w is the time it takes
for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long
will it take for all nodes to receive the signal? If it
is impossible, return -1.



Example 1:



Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2


Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
*/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] table = new int[N][N];
        for (int i = 0; i< times.length; i++){
            table[times[i][0]-1][times[i][1]-1] = times[i][2];
        }
        int[] res = dijkstra(table, K-1);
        int max = Integer.MIN_VALUE;
        for (int re : res) {
            if (re > max)
                max = re;
        }
        if (max == Integer.MAX_VALUE)
            return -1;
        else return max;
    }
    int minDistance(int distances[], Boolean visited[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < distances.length; v++)
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                min_index = v;
            }
        return min_index;
    }
    int[] dijkstra(int graph[][], int src) {
        int distances[] = new int[graph.length];
        Boolean visited[] = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distances[src] = 0;

        for (int count = 0; count < graph.length - 1; count++) {
            int u = minDistance(distances, visited);
            visited[u] = true;
            for (int v = 0; v < graph.length; v++)
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v])
                    distances[v] = distances[u] + graph[u][v];

        }
        return distances;
    }
}