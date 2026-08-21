class Pair{
    int first;
    int second;

    public Pair(int f, int s){
        first = f;
        second = s;
    }
}

class Solution {
    public void bfs(int row, int col, int[][] vis, char[][] grid, int[] delrow, int[] delcol){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int vis[][] = new int[m][n];
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    bfs(i, j, vis, grid, delrow, delcol);
                }
            }
        }
        return cnt;
    }
}
