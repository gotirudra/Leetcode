public class Solution {
    private static final int CHAR_COUNT = 26;
    private static final int INF = 1_000_000_000;

    private int[][] buildConversionGraph(List<Character> original, List<Character> changed, List<Integer> cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];
        for (int i = 0; i < CHAR_COUNT; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for (int i = 0; i < cost.size(); i++) {
            int from = original.get(i) - 'a';
            int to = changed.get(i) - 'a';
            graph[from][to] = Math.min(graph[from][to], cost.get(i));
        }
        return graph;
    }

    private void optimizeConversionPaths(int[][] graph) {
        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }

    private long computeTotalConversionCost(String source, String target, int[][] graph) {
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }
        return totalCost;
    }

    public long minimumCost(String source, String target, List<Character> original, List<Character> changed, List<Integer> cost) {
        int[][] conversionGraph = buildConversionGraph(original, changed, cost);
        optimizeConversionPaths(conversionGraph);
        return computeTotalConversionCost(source, target, conversionGraph);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String source = "abc";
        String target = "bca";

        Character[] originalArray = {'a', 'b', 'c'};
        Character[] changedArray = {'b', 'c', 'a'};
        Integer[] costArray = {1, 2, 3};

        List<Character> original = Arrays.asList(originalArray);
        List<Character> changed = Arrays.asList(changedArray);
        List<Integer> cost = Arrays.asList(costArray);

        long result = solution.minimumCost(source, target, original, changed, cost);
        System.out.println(result);  // Output the result
    }
}
