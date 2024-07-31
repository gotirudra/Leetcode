class Solution {
public:
    int shelfWidth, n;
    int dp[1000][1001]; // dp[i][j] height for book i with layer Width_rem=j

    int f(int i, int Width_rem, int layerH, vector<vector<int>>& books) {
        if (i<0) return layerH; // Base case: no more books to place
        if (dp[i][Width_rem] != -1) return dp[i][Width_rem]; 

        int w=books[i][0], h=books[i][1];

        // Option 1: Put book in a new layer
        int newLayer=layerH+f(i-1, shelfWidth-w, h, books);

        // Option 2: Put book in the same layer
        int sameLayer = INT_MAX;
        if (w <= Width_rem) {
            sameLayer = f(i-1, Width_rem-w, max(h, layerH), books);
        }

        return dp[i][Width_rem] = min(newLayer, sameLayer);
    }

    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        this->shelfWidth=shelfWidth;
        n=books.size();
        memset(dp, -1, sizeof(dp)); 
        return f(n-1, shelfWidth, 0, books); // Start from the last book
    }
};




auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();
