class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();

        while (startRow <= endRow && startCol <= endCol) {
            //Top Boundary
            for(int j = startCol; j <= endCol; j++){
                spiral.add(matrix[startRow][j]);
            }

            //Right Boundary
            for(int i = startRow+1; i <= endRow; i++){
                spiral.add(matrix[i][endCol]);
            }

            //Bottom
            for(int j = endCol-1; j >= startCol; j--){
                if (startRow == endRow) {
                    break;
                }
                spiral.add(matrix[endRow][j]);
            }

            //Left
            for(int i = endRow-1; i >= startRow+1; i--){
                if (startCol == endCol) {
                    break;
                }
                spiral.add(matrix[i][startCol]);
            }

            startRow++;
            startCol++;
            endRow--; 
            endCol--;
        }

        return spiral;
    }
}
