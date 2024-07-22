class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] result = new int[k][k];
        
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);
        
        if (rowOrder == null || colOrder == null) {
            return new int[0][0];  // Return empty matrix if any topological sort failed due to a cycle.
        }
        
        int[] rowIndex = new int[k + 1];
        int[] colIndex = new int[k + 1];
        
        for (int i = 0; i < k; ++i) {
            rowIndex[rowOrder[i]] = i;
            colIndex[colOrder[i]] = i;
        }
        
        for (int i = 1; i <= k; ++i) {
            result[rowIndex[i]][colIndex[i]] = i;
        }
        
        return result;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        int[] indegree = new int[k + 1];
        List<Integer>[] graph = new ArrayList[k + 1];
        
        for (int i = 1; i <= k; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] cond : conditions) {
            if (graph[cond[0]].add(cond[1])) {
                ++indegree[cond[1]];
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] order = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            
            for (int neighbor : graph[node]) {
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return index == k ? order : null;
    }
}
