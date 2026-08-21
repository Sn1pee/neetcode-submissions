class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int srow = 0;
        int scol = n-1;

        while(srow < m && scol >= 0){
            int src = matrix[srow][scol];

            if(target == src) return true;
            else if(target > src){
                srow++;
            }
            else{
                scol--;
            }
        }

        return false;
    }
}
