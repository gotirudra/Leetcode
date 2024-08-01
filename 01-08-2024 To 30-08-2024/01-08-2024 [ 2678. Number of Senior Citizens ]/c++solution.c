class Solution {
public:
    int countSeniors(const std::vector<std::string>& details) {
        int count = 0;
        
        for (const std::string& detail : details) {
            // Extract the age part from the string
            std::string ageStr = detail.substr(11, 2);
            int age = std::stoi(ageStr);
            
            // Check if the age is strictly more than 60
            if (age > 60) {
                count++;
            }
        }
        
        return count;
    }
};
