
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Arrays.sort(obstacles, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int n = obstacles.length;
        int dir = 0; 
        int posX = 0, posY = 0;
        int res = 0;

        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int j = 0; j < command; j++) {
                    int newX = posX + (dir == 1 ? 1 : dir == 3 ? -1 : 0);
                    int newY = posY + (dir == 0 ? 1 : dir == 2 ? -1 : 0);

                    int l = 0, r = n;
                    while (l < r) {
                        int mid = (l + r) / 2;
                        if (obstacles[mid][0] >= newX) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }

                    boolean flag = false;
                    while (l < n && obstacles[l][0] == newX) {
                        if (obstacles[l][1] == newY) {
                            flag = true;
                            break;
                        }
                        l++;
                    }

                    if (!flag) {
                        posX = newX;
                        posY = newY;
                    } else {
                        break;
                    }
                }

                res = Math.max(res, posX * posX + posY * posY);
            }
        }
        return res;
    }
}
