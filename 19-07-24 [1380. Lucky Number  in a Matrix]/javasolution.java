

import java.util.ArrayList;
import java.util.List;

//---------------------------------------------------------------------------------------------------

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> minInRows = new ArrayList<>();
        int[] maxInCols = new int[matrix[0].length];
        
        // Initialize maxInCols with minimum possible integer value
        for (int i = 0; i < maxInCols.length; i++) {
            maxInCols[i] = Integer.MIN_VALUE;
        }
        
        // Find the minimum value in each row
        for (int[] row : matrix) {
            int minValue = Integer.MAX_VALUE;
            for (int value : row) {
                minValue = Math.min(minValue, value);
            }
            minInRows.add(minValue);
        }
        
        // Find the maximum value in each column
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                maxInCols[col] = Math.max(maxInCols[col], matrix[row][col]);
            }
        }
        
        // Find the intersection of minInRows and maxInCols
        List<Integer> luckyNums = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == minInRows.get(row) && matrix[row][col] == maxInCols[col]) {
                    luckyNums.add(matrix[row][col]);
                }
            }
        }
        
        return luckyNums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };

        List<Integer> result = sol.luckyNumbers(matrix);

        System.out.println("Lucky numbers:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

//------------------------------------------------------------------------------------------------------
