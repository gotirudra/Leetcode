import java.util.Arrays;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0; 
      
        int[] dp = new int[n]; 
        dp[0] = 1;              

        int p1 = 0; 
        int p2 = 0; 
        int p3 = 0; 

        for (int i = 1; i < n; i++) {
            
            int twoMul = dp[p1] * 2;
            int threeMul = dp[p2] * 3;
            int fiveMul = dp[p3] * 5;

            dp[i] = Math.min(twoMul, Math.min(threeMul, fiveMul));

            if (dp[i] == twoMul) p1++;
            if (dp[i] == threeMul) p2++;
            if (dp[i] == fiveMul) p3++;
        }

        return dp[n - 1]; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10; 
        System.out.println(sol.nthUglyNumber(n));
    }
}
