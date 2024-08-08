import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // East, South, West, North
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{rStart, cStart});
        int steps = 1, d = 0;

        while (result.size() < rows * cols) {
            for (int i = 0; i < steps; i++) {
                rStart += directions[d][0];
                cStart += directions[d][1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result.add(new int[]{rStart, cStart});
                }
            }

            d = (d + 1) % 4;

            if (d == 0 || d == 2) {
                steps++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
