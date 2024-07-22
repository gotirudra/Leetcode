class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        int n = names.size();
        // Create a list of pairs
        vector<pair<int, string>> people;
        for (int i = 0; i < n; i++) {
            people.push_back({heights[i], names[i]});
        }

        // Sort the list based on heights in descending order
        sort(people.begin(), people.end(), [](pair<int, string>& a, pair<int, string>& b) {
            return b.first < a.first;
        });

        // Extract the sorted names
        vector<string> sortedNames(n);
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].second;
        }

        return sortedNames;
    }
};
