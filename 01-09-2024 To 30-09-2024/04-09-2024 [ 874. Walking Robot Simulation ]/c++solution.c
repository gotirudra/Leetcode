class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        ranges::sort(obstacles);
        int n = obstacles.size();
        int dir = 0;
        int posX = 0, posY = 0;
        int res = 0;
        for (int i : commands) {
            if (i == -2) {
                dir += 3;
                dir %= 4;
               
            }
            else if (i == -1) {
                dir++;
                dir %= 4;
               
            }
            else {
                for (int j = 0; j < i; j++) {
                    
                    int newX = posX + (dir==1) - (dir==3);
                    int newY = posY + (!dir) - (dir==2);
                    
                    int l = 0, r = n;
                    while (l < r) {
                        int mid = (l+r) / 2;
                        if (obstacles[mid][0] >= newX) {
                            r = mid;
                        }
                        else {
                            l = mid+1;
                        }
                    }

                    bool flag = false;
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
                    }
                    else { 
                        break;
                    }
                }

                res = max(res, posX*posX + posY*posY);
            }
        }
        return res;
    }
};
