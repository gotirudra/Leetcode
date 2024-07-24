class Solution {
public:
    // Function to map the digits of a number based on the given mapping
    int getMappedValue(int num, const std::vector<int>& mapping) {
        if (num == 0) return mapping[0]; // Special case for 0
        int mappedValue = 0;
        int factor = 1;
        while (num > 0) {
            int digit = num % 10;
            mappedValue += mapping[digit] * factor;
            factor *= 10;
            num /= 10;
        }
        return mappedValue;
    }

    // Comparator for sorting based on mapped values
    bool compareMappedValues(const std::pair<int, int>& a, const std::pair<int, int>& b) {
        return a.second < b.second;
    }

    // Function to sort nums based on their mapped values
    std::vector<int> sortJumbled(const std::vector<int>& mapping, std::vector<int>& nums) {
        // Create a vector of pairs to store original numbers and their mapped values
        std::vector<std::pair<int, int>> mappedNums;
        for (int num : nums) {
            mappedNums.emplace_back(num, getMappedValue(num, mapping));
        }

        // Sort based on the mapped values using the custom comparator
        std::stable_sort(mappedNums.begin(), mappedNums.end(), 
                         [this](const std::pair<int, int>& a, const std::pair<int, int>& b) { 
                             return compareMappedValues(a, b); 
                         });

        // Extract the sorted original numbers
        std::vector<int> sortedNums;
        for (const auto& pair : mappedNums) {
            sortedNums.push_back(pair.first);
        }

        return sortedNums;
    }
};
