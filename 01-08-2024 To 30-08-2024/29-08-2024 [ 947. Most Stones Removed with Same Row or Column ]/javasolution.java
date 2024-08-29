class Solution {
    public int removeStones(int[][] stones) {
        int numOfIslands = 0;
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < stones.length; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < stones.length; ++i) {
            for (int j = i + 1; j < stones.length; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < stones.length; ++i) {
            if (seen.add(i)) {
                dfs(graph, i, seen);
                ++numOfIslands;
            }
        }

        return stones.length - numOfIslands;
    }

    private void dfs(List<List<Integer>> graph, int u, Set<Integer> seen) {
        for (int v : graph.get(u)) {
            if (seen.add(v)) {
                dfs(graph, v, seen);
            }
        }
    }
}
