class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int rowSumSize = rowSum.size();
        int colSumSize = colSum.size();

        // Initialize result matrix
        vector<vector<int>> result(rowSumSize, vector<int>(colSumSize, 0));

        // Restore the matrix
        for (int i = 0; i < rowSumSize; ++i) {
            for (int j = 0; j < colSumSize; ++j) {
                int value = min(rowSum[i], colSum[j]);
                result[i][j] = value;
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }

        return result;
    }
};
