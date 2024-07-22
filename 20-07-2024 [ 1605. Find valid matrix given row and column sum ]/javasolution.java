class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowSumSize = rowSum.length;
        int colSumSize = colSum.length;

        int[][] result = new int[rowSumSize][colSumSize];
        int[] returnColumnSizes = new int[rowSumSize];
        Arrays.fill(returnColumnSizes, colSumSize);

        for (int i = 0; i < rowSumSize; i++) {
            for (int j = 0; j < colSumSize; j++) {
                result[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= result[i][j];
                colSum[j] -= result[i][j];
            }
        }

        return result;
    }
}
