public class Solution {
    public int[] frequencySort(int[] nums) {
        // Create a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Convert the array to a list to use the Collections.sort method
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        // Sort the list based on frequency and value
        Collections.sort(numList, (a, b) -> {
            int freqCompare = frequencyMap.get(a) - frequencyMap.get(b);
            if (freqCompare == 0) {
                return b - a;  // If frequencies are equal, sort by value in decreasing order
            }
            return freqCompare;
        });

        // Convert the list back to an array
        int[] sortedArray = new int[nums.length];
        for (int i = 0; i < numList.size(); i++) {
            sortedArray[i] = numList.get(i);
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(solution.frequencySort(nums1)));  // Output: [3, 1, 1, 2, 2, 2]

        int[] nums2 = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(solution.frequencySort(nums2)));  // Output: [1, 3, 3, 2, 2]

        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println(Arrays.toString(solution.frequencySort(nums3)));  // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
