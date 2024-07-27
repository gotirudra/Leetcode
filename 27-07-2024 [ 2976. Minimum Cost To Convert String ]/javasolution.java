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

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(solution.minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

        // Example 2
        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a', 'c'};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(solution.minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

        // Example 3
        String source3 = "abcd";
        String target3 = "abce";
        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(solution.minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
    }
}
