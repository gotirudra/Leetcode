class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // Create a list of pairs
        List<Pair> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(new Pair(names[i], heights[i]));
        }
        
        // Sort the list based on heights in descending order
        people.sort((a, b) -> b.height - a.height);
        
        // Extract the sorted names
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people.get(i).name;
        }
        
        return sortedNames;
    }
    
    // Helper class to hold name and height together
    class Pair {
        String name;
        int height;
        
        Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] names1 = {"Mary", "John", "Emma"};
        int[] heights1 = {180, 165, 170};
        System.out.println(Arrays.toString(solution.sortPeople(names1, heights1))); // Output: [Mary, Emma, John]
        
        String[] names2 = {"Alice", "Bob", "Bob"};
        int[] heights2 = {155, 185, 150};
        System.out.println(Arrays.toString(solution.sortPeople(names2, heights2))); // Output: [Bob, Alice, Bob]
    }
}
