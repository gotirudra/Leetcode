import java.util.*;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
     
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, succProb[i]));
            adj.get(v).add(new Pair(u, succProb[i]));
        }

        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Pair pair : adj.get(curr)) {
                int next = pair.node;
                double prob = pair.probability;
                double newProb = dist[curr] * prob;

                if (newProb > dist[next]) {
                    dist[next] = newProb;
                    queue.offer(next);
                }
            }
        }

        return dist[end];
    }

    private class Pair {
        int node;
        double probability;

        Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    
}
