class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        int size = n * (n + 1) / 2;
        int[] arr = new int[size];
          
        int index = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = i; j < n; ++j) {
                sum += nums[j];
                arr[index++] = sum;
            }
        }
        
        Arrays.sort(arr);
      
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = left - 1; i < right; ++i) {
            ans = (ans + arr[i]) % MOD;
        }
        
        return (int) ans;
    }
}
