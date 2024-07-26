class Solution {
public:
    int findTheCity(int n, std::vector<std::vector<int>>& edges, int distanceThreshold) {
        // Create the adjacency list
        std::vector<std::vector<std::pair<int, int>>> adj(n);
        for (const auto& edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adj[from].emplace_back(to, weight);
            adj[to].emplace_back(from, weight);
        }

        auto dijkstra = [&](int start) {
            std::vector<int> dist(n, INT_MAX);
            dist[start] = 0;
            std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<>> pq;
            pq.emplace(0, start);

            while (!pq.empty()) {
                auto [currentDist, u] = pq.top();
                pq.pop();

                if (currentDist > dist[u]) continue;

                for (const auto& [v, weight] : adj[u]) {
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.emplace(dist[v], v);
                    }
                }
            }
            return dist;
        };

        int resultCity = -1;
        int smallestCount = INT_MAX;

        for (int i = 0; i < n; ++i) {
            std::vector<int> dist = dijkstra(i);
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && dist[j] <= distanceThreshold) {
                    ++count;
                }
            }

            if (count < smallestCount || (count == smallestCount && i > resultCity)) {
                smallestCount = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
};
