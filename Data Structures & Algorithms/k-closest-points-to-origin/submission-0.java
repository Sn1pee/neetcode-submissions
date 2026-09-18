class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[]coords: points){
            int x = coords[0];
            int y = coords[1];

            pq.offer(new int[]{x, y});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int n = pq.size();
        int[][] ans = new int[n][2];

        for(int i = 0; i < n; i++){
            int[] it = pq.poll();
            ans[i][0] = it[0];
            ans[i][1] = it[1];
        }

        return ans;
    }
}
