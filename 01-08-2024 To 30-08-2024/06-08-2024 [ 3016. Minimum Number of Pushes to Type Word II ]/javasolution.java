public class Solution {
    public int minimumPushes(String word) {
        int[] letterFreq = new int[26];
        for (char c : word.toCharArray()) {
            letterFreq[c - 'a']++;
        }
        
        Arrays.sort(letterFreq);
        
        int totalPresses = 0;
        for (int i = 25; i >= 0; i--) {
            if (letterFreq[i] == 0) break;
            totalPresses += ((25 - i) / 8 + 1) * letterFreq[i];
        }
        
        return totalPresses;
    }

}
