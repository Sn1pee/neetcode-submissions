class Pair{
    int first;
    int second;

    public Pair(int f, int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    int area = bfs(i, j, vis, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int bfs(int row, int col, int[][] vis, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;
        
        int area = 1;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                    area++;
                }
            }
        }

        return area;
    }
}
