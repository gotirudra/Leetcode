class Solution {
public:
    int getLucky(string s, int k) {
        string sb;
        int sum = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            sb += to_string(((s[i]) - 'a' + 1));
        }
        for(int i=0;i<sb.length();i++){
            sum += ((sb[i])-'0');
        }
        k--;
        while(k!=0){
            int num = sum;
            sum = 0;
            while(num!=0){
                int a = num%10;
                num/=10;
                sum += a;
            }
            k--;
        }
        return sum;
    }
};
