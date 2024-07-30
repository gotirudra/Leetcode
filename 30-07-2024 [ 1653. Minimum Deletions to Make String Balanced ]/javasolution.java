import java.util.Scanner;

public class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int B_pre = s.charAt(0) == 'b' ? 1 : 0; // Number of 'b's seen so far
        int A_suf = countA(s); // Count 'a's in s
        int cnt = B_pre + A_suf - 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'b') {
                B_pre++;
            }
            if (s.charAt(i - 1) == 'a') {
                A_suf--;
            }
            cnt = Math.min(cnt, B_pre + A_suf - 1);
        }

        return cnt;
    }

    private int countA(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        String s = scanner.nextLine();
        System.out.println(solution.minimumDeletions(s));

        scanner.close();
    }
}
