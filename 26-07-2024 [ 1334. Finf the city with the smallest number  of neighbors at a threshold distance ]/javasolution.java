import java.util.Arrays;

public class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];
        
        // Initialize distances array with maximum value
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Distance to itself is 0
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }
        
        // Fill initial distances based on given edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distances[from][to] = weight;
            distances[to][from] = weight;
        }
        
        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }
        
        // Find the city with the smallest number of reachable cities within distanceThreshold
        int resultCity = -1;
        int smallestCount = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distances[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            
            if (count < smallestCount || (count == smallestCount && i > resultCity)) {
                smallestCount = count;
                resultCity = i;
            }
        }
        
        return resultCity;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 4;
        int[][] edges1 = { {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1} };
        int distanceThreshold1 = 4;
        System.out.println(sol.findTheCity(n1, edges1, distanceThreshold1)); // Output: 3

        int n2 = 5;
        int[][] edges2 = { {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1} };
        int distanceThreshold2 = 2;
        System.out.println(sol.findTheCity(n2, edges2, distanceThreshold2)); // Output: 0
    }
}
