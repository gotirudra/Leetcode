/*    "copy & past only code between lines (//----------//) for getting result"  */
/*    "use gdb compiler for getting output of whole code"      */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//---------------------------------------------------------------------------------------------------

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

//------------------------------------------------------------------------------------------------------

int main() {
    Solution sol;

    // Example test case
    vector<int> rowSum = {3, 8};
    vector<int> colSum = {4, 7};

    // Call restoreMatrix using the instance 'sol'
    vector<vector<int>> result = sol.restoreMatrix(rowSum, colSum);

    // Print the result
    cout << "Restored matrix:" << endl;
    for (const auto& row : result) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }

    return 0;
}
