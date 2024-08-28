class Solution {
public:
    long long generatePalindrome(long long prefix, bool isEven) {
        string s = to_string(prefix);
        string rev = s.substr(0, s.length() - !isEven);
        reverse(rev.begin(), rev.end());
        return stoll(s + rev);
    }
    string nearestPalindromic(string n) {
        if (n == "1") return "0";
        
        long long num = stoll(n);
        int length = n.size();
        long long prefix = stoll(n.substr(0, (length + 1) / 2));
        
        set<long long> candidates = {
            (long long)pow(10, length - 1) - 1,
            (long long)pow(10, length) + 1,
            generatePalindrome(prefix - 1, length % 2 == 0),
            generatePalindrome(prefix, length % 2 == 0),
            generatePalindrome(prefix + 1, length % 2 == 0)
        };
        
        candidates.erase(num);
        return to_string(*min_element(candidates.begin(), candidates.end(), 
                       [num](long long a, long long b) {
                           long long diffA = abs(a - num);
                           long long diffB = abs(b - num);
                           return diffA == diffB ? a < b : diffA < diffB;
                       }));
    }
};
