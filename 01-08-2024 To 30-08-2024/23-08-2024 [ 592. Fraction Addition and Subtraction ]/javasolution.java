public class Solution {

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    private void reduce(int[] fraction) {
        int gcd_ab = gcd(Math.abs(fraction[0]), fraction[1]);
        fraction[0] /= gcd_ab;
        fraction[1] /= gcd_ab;
    }

    private int parseNumber(String expression, int[] i) {
        int sign = 1;
        if (expression.charAt(i[0]) == '-') {
            sign = -1;
            i[0]++;
        } else if (expression.charAt(i[0]) == '+') {
            i[0]++;
        }
        int num = 0;
        while (i[0] < expression.length() && Character.isDigit(expression.charAt(i[0]))) {
            num = num * 10 + (expression.charAt(i[0]) - '0');
            i[0]++;
        }
        return sign * num;
    }

    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;
        int[] i = {0}; // Use array to mimic passing by reference
        while (i[0] < expression.length()) {
            int num = parseNumber(expression, i);
            i[0]++; // Skip the '/'
            int den = parseNumber(expression, i);
            int LCM = lcm(denominator, den);
            numerator = numerator * (LCM / denominator) + num * (LCM / den);
            denominator = LCM;
        }
        if (numerator == 0) return "0/1";
        int[] fraction = {numerator, denominator};
        reduce(fraction);
        return fraction[0] + "/" + fraction[1];
    }

    
}
