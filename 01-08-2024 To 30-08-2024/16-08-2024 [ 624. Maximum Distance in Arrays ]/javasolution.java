class Solution {
    public static int maxDistance(List<List<Integer>> arrays) {
        int xMin = arrays.get(0).get(0);
        int xMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int diff = 0;
        int m = arrays.size();

        // Single pass
        for (int i = 1; i < m; i++) {
            List<Integer> arr = arrays.get(i);
            int a0 = arr.get(0);
            int aN = arr.get(arr.size() - 1);
            diff = Math.max(diff, Math.max(aN - xMin, xMax - a0));
            xMin = Math.min(a0, xMin);
            xMax = Math.max(aN, xMax);
        }

        return diff;
    }
}
