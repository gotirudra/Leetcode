class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        
        // Initialize the cost matrix with infinity (large number) for all transformations.
        int[][] transformationCost = new int[26][26];
        for (int[] row : transformationCost) {
            Arrays.fill(row, Integer.MAX_VALUE / 2); // Using Integer.MAX_VALUE/2 to avoid overflow
        }

        // The cost to transform a character to itself is zero.
        for (int i = 0; i < 26; i++) {
            transformationCost[i][i] = 0;
        }

        // Fill the cost matrix with given costs.
        for (int i = 0; i < m; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            transformationCost[u][v] = Math.min(transformationCost[u][v], cost[i]);
        }

        // Floyd-Warshall algorithm to find the shortest path between all pairs of characters.
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (transformationCost[i][j] > transformationCost[i][k] + transformationCost[k][j]) {
                        transformationCost[i][j] = transformationCost[i][k] + transformationCost[k][j];
                    }
                }
            }
        }

        // Calculate the total minimum cost to transform source to target.
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';
            int costToTransform = transformationCost[srcChar][tgtChar];
            if (costToTransform == Integer.MAX_VALUE / 2) {
                return -1; // Impossible to transform
            }
            totalCost += costToTransform;
        }

        return totalCost;
    }

}
