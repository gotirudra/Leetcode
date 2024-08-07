class Solution {
private:
    const std::vector<std::string> LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    const std::vector<std::string> TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    const std::vector<std::string> THOUSANDS = {"", "Thousand", "Million", "Billion"};

public:
    std::string numberToWords(int num) {
        if (num == 0) return "Zero";
        std::string words;
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                std::string part;
                helper(num % 1000, part);
                words = part + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        words.erase(words.find_last_not_of(" \n\r\t")+1);
        return words;
    }

private:
    void helper(int num, std::string &part) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            part += LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            part += TENS[num / 10] + " ";
            helper(num % 10, part);
        } else {
            part += LESS_THAN_20[num / 100] + " Hundred ";
            helper(num % 100, part);
        }
    }
};
