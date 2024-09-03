class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int n = s.length();
    
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
  
        for (int i = 0; i < sb.length(); i++) {
            sum += sb.charAt(i) - '0';
        }
        
        k--;
      
        while (k != 0) {
            int num = sum;
            sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            k--;
        }
        
        return sum;
    }
}
