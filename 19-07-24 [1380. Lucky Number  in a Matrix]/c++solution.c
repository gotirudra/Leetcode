#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

using namespace std;

//----------------------------------------------------------------------------------------------------

class Solution {
public:
    vector<int> luckyNumbers(const vector<vector<int>>& matrix) {
        vector<int> minInRows;
        vector<int> maxInCols(matrix[0].size(), INT_MIN);
        
        // Find the minimum value in each row
        for (const auto& row : matrix) {
            int minValue = *min_element(row.begin(), row.end());
            minInRows.push_back(minValue);
        }
        
        // Find the maximum value in each column
        for (size_t col = 0; col < matrix[0].size(); ++col) {
            for (size_t row = 0; row < matrix.size(); ++row) {
                maxInCols[col] = max(maxInCols[col], matrix[row][col]);
            }
        }
        
        // Find the intersection of minInRows and maxInCols
        vector<int> luckyNums;
        for (size_t row = 0; row < matrix.size(); ++row) {
            for (size_t col = 0; col < matrix[0].size(); ++col) {
                if (matrix[row][col] == minInRows[row] && matrix[row][col] == maxInCols[col]) {
                    luckyNums.push_back(matrix[row][col]);
                }
            }
        }
        
        return luckyNums;
    }
};

//----------------------------------------------------------------------------------------------------

int main() {
    Solution sol;

    vector<vector<int>> matrix = {
        {3, 7, 8},
        {9, 11, 13},
        {15, 16, 17}
    };

    vector<int> luckyNumbers = sol.luckyNumbers(matrix);

    cout << "Lucky numbers: ";
    for (int num : luckyNumbers) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
