class Solution {
    public boolean dfs(int node, int[] vis, int[] pathvis, List<List<Integer>> adj){
        vis[node] = 1;
        pathvis[node] = 1;

        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, vis, pathvis, adj) == false) return false;
            }
            else if(pathvis[it] == 1) return false;
        }
        pathvis[node] = 0;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        int vis[] = new int[v];
        int pathvis[] = new int[v];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr: prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, pathvis, adj) == false){
                    return false;
                }
            }
        }

        return true;
    }
}
