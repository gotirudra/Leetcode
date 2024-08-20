class Solution {
    private int[][] dp = new int[101][201];

    private int helper(int i, int m, List<Integer> piles) {
        if (i >= piles.size())
            return 0;

        if (dp[i][m] != -1)
            return dp[i][m];

        int total = 0;
        int ans = Integer.MIN_VALUE;

        for (int j = 0; j < 2 * m; j++) {
            if (i + j < piles.size())
                total += piles.get(i + j);

            ans = Math.max(ans, total - helper(i + j + 1, Math.max(m, j + 1), piles));
        }

        dp[i][m] = ans;
        return ans;
    }

    public int stoneGameII(int[] pilesArray) {
      
        List<Integer> piles = new ArrayList<>();
        for (int pile : pilesArray) {
            piles.add(pile);
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        int diff = helper(0, 1, piles);

        return (sum + diff) / 2;
    }
}
