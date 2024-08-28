class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid1.size(), n = grid1[0].size(), res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid1[i][j] + grid2[i][j] == 2)
                    res += dfs(i, j, grid1, grid2);
        return res;
    }
private:
    int dir[5] = {1, 0, -1, 0, 1};
    bool dfs(int r, int c, vector<vector<int>>& grid1, vector<vector<int>>& grid2){
        if (r < 0 or r == grid1.size() or c < 0 or c == grid1[0].size() or grid2[r][c] == 0)
            return true;
        else if (grid1[r][c] != grid2[r][c])
            return false;
        grid2[r][c] = 0;
        bool res = true;
        for (int i = 0; i < 4; i++)
            res &= dfs(r + dir[i], c + dir[i + 1], grid1, grid2);
        return res;
    }
};
