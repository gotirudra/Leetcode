class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;

        // Count the total number of 1's in the array
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        // Edge case: if there are no 1's or all are 1's
        if (totalOnes == 0 || totalOnes == nums.length) {
            return 0;
        }

        int n = nums.length;
        int minSwaps = Integer.MAX_VALUE;
        int currentZeros = 0;

        // Initial window calculation
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 0) {
                currentZeros++;
            }
        }

        minSwaps = currentZeros;

        // Slide the window across the array
        for (int i = 1; i < n; i++) {
            // Remove the element going out of the window
            if (nums[i - 1] == 0) {
                currentZeros--;
            }
            // Add the new element coming into the window
            if (nums[(i + totalOnes - 1) % n] == 0) {
                currentZeros++;
            }

            // Update the minimum swaps
            minSwaps = Math.min(minSwaps, currentZeros);
        }

        return minSwaps;
    }
}
