class Pair{
    int f;
    int s;
    int t;

    public Pair(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = Integer.MAX_VALUE;
        int vis[][] = new int[m][n];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            int row = q.peek().f;
            int col = q.peek().s;
            int d = q.peek().t;
            q.poll();
            grid[row][col] = d;

            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == max){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, d + 1));
                }
            }
        }
    }
}
