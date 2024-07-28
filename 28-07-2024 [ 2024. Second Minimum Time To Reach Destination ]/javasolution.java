class Solution {
    private static int howLong(int needed, int time, int change) {
        int ans = 0;
        for (int i = 0; i < needed; i++) {
            int turn = ans / change;
            if ((turn % 2) != 0) {
                ans += change - (ans % change);
            }
            ans += time;
        }
        return ans;
    }

    public static int secondMinimum(int N, int[][] edges, int time, int change) {
        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            G.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            G.get(edge[0] - 1).add(edge[1] - 1);
            G.get(edge[1] - 1).add(edge[0] - 1);
        }

        Deque<Integer> Q = new ArrayDeque<>();
        boolean[] seen = new boolean[N * 2];
        Q.addFirst(0);
        seen[0] = true;

        int maxLength = Integer.MAX_VALUE;

        int wave = 0;
        boolean odd = true;
        while (!Q.isEmpty()) {
            int thisRound = Q.size();
            odd = !odd;
            for (int i = 0; i < thisRound; i++) {
                int pos = Q.pollFirst();

                if (pos == N - 1) {
                    if (maxLength == Integer.MAX_VALUE) {
                        maxLength = wave + 2;
                        continue;
                    } else {
                        maxLength = Math.min(maxLength, wave);
                        return howLong(maxLength, time, change);
                    }
                }

                for (int next : G.get(pos)) {
                    if (seen[next * 2 + (odd ? 0 : 1)]) {
                        continue;
                    }

                    seen[next * 2 + (odd ? 0 : 1)] = true;
                    Q.addLast(next);
                }
            }
            wave++;

            if (maxLength < wave) {
                break;
            }
        }

        return howLong(maxLength, time, change);
    }
}
