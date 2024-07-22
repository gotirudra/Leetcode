class Solution {
public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        vector<vector<int>> result(k, vector<int>(k, 0));
        
        vector<int> rowOrder = topologicalSort(k, rowConditions);
        vector<int> colOrder = topologicalSort(k, colConditions);
        
        // If the topological sort failed (cycle detected), return an empty matrix
        if (rowOrder.empty() || colOrder.empty()) {
            return {};
        }
        
        // Map to find index positions in the final matrix
        unordered_map<int, int> rowIndex, colIndex;
        for (int i = 0; i < k; ++i) {
            rowIndex[rowOrder[i]] = i;
            colIndex[colOrder[i]] = i;
        }
        
        // Fill the result matrix based on row and column orders
        for (int i = 1; i <= k; ++i) {
            result[rowIndex[i]][colIndex[i]] = i;
        }
        
        return result;
    }

private:
    vector<int> topologicalSort(int k, vector<vector<int>>& conditions) {
        vector<int> indegree(k + 1, 0);
        unordered_map<int, unordered_set<int>> graph;
        
        // Build the graph and indegree array
        for (const auto& cond : conditions) {
            if (graph[cond[0]].insert(cond[1]).second) {
                ++indegree[cond[1]];
            }
        }
        
        // Queue for nodes with zero indegree
        queue<int> q;
        for (int i = 1; i <= k; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        
        vector<int> order;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            order.push_back(node);
            
            // Process neighbors
            for (int neighbor : graph[node]) {
                if (--indegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
        
        // Check if topological sort is valid (contains all nodes)
        return order.size() == k ? order : vector<int>();
    }
};
