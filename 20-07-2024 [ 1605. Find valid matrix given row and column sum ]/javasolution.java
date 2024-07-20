/*    "copy & past only solution function for getting result"  */

import java.util.Arrays;

//-----------------------------------------------------------------------
                                                                      
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

//-------------------------------------------------------------------------

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test case
        int[] rowSum = {3, 8};
        int[] colSum = {4, 7};

        int[][] result = sol.restoreMatrix(rowSum, colSum);

        // Print the result
        System.out.println("Restored matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
