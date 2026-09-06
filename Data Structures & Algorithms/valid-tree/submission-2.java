class Solution {
    public boolean validTree(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[V];
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
            
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, -1});
        vis[0] = 1;
        while(!q.isEmpty()){
            int[] it = q.poll();
            int node = it[0];
            int parent = it[1];
            for(Integer id : adj.get(node)){
                if(vis[id] == 0){
                    vis[id] = 1;
                    q.add(new int[]{id, node});
                }
                else if(parent != id){
                    return false;
                }
            }
        }     
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                return false;
            }
        }
        return true;
    }
}
