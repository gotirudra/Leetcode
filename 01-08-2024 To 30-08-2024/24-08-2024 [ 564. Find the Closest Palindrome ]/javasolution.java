class Solution {
    private long generatePalindrome(long prefix, boolean isEven) {
        String s = Long.toString(prefix);
        String rev = new StringBuilder(s.substring(0, s.length() - (isEven ? 0 : 1))).reverse().toString();
        return Long.parseLong(s + rev);
    }

    public String nearestPalindromic(String n) {
        if (n.equals("1")) return "0";
        
        long num = Long.parseLong(n);
        int length = n.length();
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        
        Set<Long> candidates = new HashSet<>(Arrays.asList(
            (long) Math.pow(10, length - 1) - 1,
            (long) Math.pow(10, length) + 1,
            generatePalindrome(prefix - 1, length % 2 == 0),
            generatePalindrome(prefix, length % 2 == 0),
            generatePalindrome(prefix + 1, length % 2 == 0)
        ));
        
        candidates.remove(num);
        return Long.toString(Collections.min(candidates, (a, b) -> {
            long diffA = Math.abs(a - num);
            long diffB = Math.abs(b - num);
            return diffA == diffB ? Long.compare(a, b) : Long.compare(diffA, diffB);
        }));
    }
}
