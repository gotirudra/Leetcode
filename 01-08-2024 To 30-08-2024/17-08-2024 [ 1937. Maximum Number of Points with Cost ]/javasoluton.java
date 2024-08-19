class Solution {
    public long maxPoints(int[][] grid) {
        int width = grid[0].length;
        long[] current = new long[width];
        long[] previous = new long[width];
        long maxScore = 0;

        for (int[] level : grid) {
            long peak = 0;

            for (int i = 0; i < width; ++i) {
                peak = Math.max(peak - 1, previous[i]);
                current[i] = peak;
            }

            peak = 0;

            for (int i = width - 1; i >= 0; --i) {
                peak = Math.max(peak - 1, previous[i]);
                current[i] = Math.max(current[i], peak) + level[i];
            }

            long[] temp = previous;
            previous = current;
            current = temp;
        }

        // Compute final result
        maxScore = Arrays.stream(previous).max().getAsLong();
        return maxScore;
    }
}
