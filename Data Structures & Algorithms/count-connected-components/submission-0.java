class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] vis = new int[n];

        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, adj, vis);
            }
        }

        return count;
    }
    public static void dfs(int node, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis);
            }
        }
    }
}
