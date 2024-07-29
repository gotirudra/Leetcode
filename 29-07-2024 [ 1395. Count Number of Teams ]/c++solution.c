class Solution {
public:
    int numTeams(vector<int>& ratings) {
        int n = ratings.size();
        int teams = 0;

        // Loop through each element and consider it as the middle element of a team
        for (int j = 0; j < n; j++) {
            int leftSmaller = 0, leftLarger = 0;
            int rightSmaller = 0, rightLarger = 0;

            // Count smaller and larger elements to the left of ratings[j]
            for (int i = 0; i < j; i++) {
                if (ratings[i] < ratings[j]) {
                    leftSmaller++;
                } else if (ratings[i] > ratings[j]) {
                    leftLarger++;
                }
            }

            // Count smaller and larger elements to the right of ratings[j]
            for (int k = j + 1; k < n; k++) {
                if (ratings[k] < ratings[j]) {
                    rightSmaller++;
                } else if (ratings[k] > ratings[j]) {
                    rightLarger++;
                }
            }

            // Calculate the number of valid teams
            teams += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }

        return teams;
    }
};
