public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = nums[left + i];
        }
        for (int i = 0; i < n2; ++i) {
            rightArray[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {5, 2, 3, 1};
        int[] sortedNums1 = solution.sortArray(nums1);
        System.out.println(Arrays.toString(sortedNums1)); // Output: [1, 2, 3, 5]

        int[] nums2 = {5, 1, 1, 2, 0, 0};
        int[] sortedNums2 = solution.sortArray(nums2);
        System.out.println(Arrays.toString(sortedNums2)); // Output: [0, 0, 1, 1, 2, 5]
    }
}
