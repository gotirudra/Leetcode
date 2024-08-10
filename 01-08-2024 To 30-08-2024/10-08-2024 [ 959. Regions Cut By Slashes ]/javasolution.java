class Solution {
    private int[] parent;
    private int[] rank;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;  
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int root = 4 * (i * n + j);
                char val = grid[i].charAt(j);

                if (val != '/') {
                    unionSets(root, root + 1); 
                    unionSets(root + 2, root + 3); 
                }
                if (val != '\\') {
                    unionSets(root, root + 3); 
                    unionSets(root + 1, root + 2); 
                }

                if (i < n - 1) {
                    unionSets(root + 2, root + 4 * n);  
                }
                if (j < n - 1) {
                    unionSets(root + 1, root + 7);
                }
            }
        }

        int regions = 0;
        for (int i = 0; i < size; ++i) {
            if (find(i) == i) {
                regions++;
            }
        }

        return regions;
    }

    private void unionSets(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
            } else if (rank[parentA] < rank[parentB]) {
                parent[parentA] = parentB;
            } else {
                parent[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);  
    }
}
