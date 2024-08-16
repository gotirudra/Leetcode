class Solution {
public:
    static int maxDistance(vector<vector<int>>& arrays) {
        int xMin=arrays[0][0], xMax=arrays[0].back();
        int diff=0;
        int m=arrays.size();
       
        for(int i=1; i<m; i++){
            vector<int> arr=arrays[i];
            int a0=arr[0], aN=arr.back();
            diff=max({diff, aN-xMin, xMax-a0});
            xMin=min(a0, xMin);
            xMax=max(aN, xMax);
        }
       
        return diff;
    }
};
 
auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();
