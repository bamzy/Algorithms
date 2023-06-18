package info.bamzy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    int ans = 0;

    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList[] adj = new ArrayList[N];      // (node, weight)
        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int t[]: times){
            adj[t[0] - 1].add(new int[]{t[1] - 1, t[2]});
        }

        boolean visited[] = new boolean[N];
        dijkstra(K-1, adj, visited);

        for(boolean v: visited){
            if(!v){
                return -1;
            }
        }

        return ans;
    }

    public void dijkstra(int source, ArrayList<int[]> adj[], boolean visited[]){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int a[], int b[]){
                return a[1] - b[1];
            }
        });

        pq.add(new int[]{source, 0});
        while(!pq.isEmpty()){
            int node[] = pq.poll();

            // skip duplicate nodes
            if(visited[node[0]]){
                continue;
            }

            visited[node[0]] = true;
            ans = node[1];

            for(int neighbor[]: adj[node[0]]){
                pq.add(new int[]{neighbor[0], neighbor[1] + node[1]});
            }
        }
    }

}