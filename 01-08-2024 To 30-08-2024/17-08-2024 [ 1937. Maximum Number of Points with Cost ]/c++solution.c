class Solution {
public:

    long long maxPoints(vector<vector<int>>& grid) {
        const int width = grid[0].size();
        vector<long long> current(width), previous(width);
        long long maxScore = 0;

        for (const auto& level : grid) {
            long long peak = 0;
            
            for (int i = 0; i < width; ++i) {
                peak = max(peak - 1, previous[i]);
                current[i] = peak;
            }
            peak = 0;
           
            for (int i = width - 1; i >= 0; --i) {
                peak = max(peak - 1, previous[i]);
                current[i] = max(current[i], peak) + level[i];
            }
            previous.swap(current);
        }

       
        maxScore = *max_element(previous.begin(), previous.end());
        return maxScore;
    }
};

static const auto speedup = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return 0;
}();
