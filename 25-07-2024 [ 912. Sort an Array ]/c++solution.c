
class Solution {
public:
    // Function to sort the array using Merge Sort and return it
    vector<int> sortArray(vector<int>& nums) {
        if (nums.size() < 2) {
            return nums;  // No need to sort if array is empty or has one element
        }
        vector<int> temp(nums.size()); // Temporary array for merging
        mergeSort(nums, temp, 0, nums.size() - 1);
        return nums;
    }

private:
    // Function to perform merge sort
    void mergeSort(vector<int>& nums, vector<int>& temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid + 1, right);
            merge(nums, temp, left, mid, right);
        }
    }

    // Function to merge two sorted halves into a single sorted array
    void merge(vector<int>& nums, vector<int>& temp, int left, int mid, int right) {
        // Copy data to the temporary array
        copy(nums.begin() + left, nums.begin() + right + 1, temp.begin() + left);

        int i = left;    // Starting index for the left subarray
        int j = mid + 1; // Starting index for the right subarray
        int k = left;    // Starting index for the merged array

        // Merge the two halves into nums
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        // Copy remaining elements of the left subarray, if any
        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        // Copy remaining elements of the right subarray, if any
        while (j <= right) {
            nums[k++] = temp[j++];
        }
    }
};
