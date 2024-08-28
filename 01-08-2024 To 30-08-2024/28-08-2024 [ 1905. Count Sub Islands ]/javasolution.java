import java.util.*;

public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private int[] dir = {1, 0, -1, 0, 1};

    private boolean dfs(int r, int c, int[][] grid1, int[][] grid2) {
        if (r < 0 || r >= grid1.length || c < 0 || c >= grid1[0].length || grid2[r][c] == 0) {
            return true;
        } else if (grid1[r][c] != grid2[r][c]) {
            return false;
        }
        
        grid2[r][c] = 0; // Mark the cell as visited
        boolean res = true;
        for (int i = 0; i < 4; i++) {
            res &= dfs(r + dir[i], c + dir[i + 1], grid1, grid2);
        }
        return res;
    }

    
}
