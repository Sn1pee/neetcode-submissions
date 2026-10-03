class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i = 0; i < m; i++){
            int[] it = flights[i];
            int s = it[0];
            int e = it[1];
            int t = it[2];

            adj.get(s).add(new int[]{e, t});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, src, 0});

        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = (int)1e9;
        dist[src] = 0;

        while(!q.isEmpty()){
            int[] it = q.poll();
            int stops = it[0];
            int node = it[1];
            int cost = it[2];

            if(stops > k) continue;

            for(int[] iter: adj.get(node)){
                int adjNode = iter[0];
                int edgeWt = iter[1];

                if(cost + edgeWt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edgeWt;
                    q.add(new int[]{stops + 1, adjNode, cost+edgeWt});
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}
