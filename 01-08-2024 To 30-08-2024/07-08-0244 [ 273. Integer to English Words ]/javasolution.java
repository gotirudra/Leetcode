class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder words = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder part = new StringBuilder();
                helper(num % 1000, part);
                words.insert(0, part.append(THOUSANDS[i]).append(" "));
            }
            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    private void helper(int num, StringBuilder part) {
        if (num == 0) {
            return;
        } else if (num < 20) {
            part.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            part.append(TENS[num / 10]).append(" ");
            helper(num % 10, part);
        } else {
            part.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(num % 100, part);
        }
    }
}
