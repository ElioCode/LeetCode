public class LeetCode1049 {
    public int lastStoneWeightII(int[] ss) {
        int n = ss.length;
        int sum = 0;
        for (int i : ss) {
            sum += i;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            int x = ss[i - 1];
            for (int j = sum/2; j >= x ; j--) {
                dp[j] = Math.max(dp[j], dp[j - x] + x);
            }
        }
        return sum - dp[sum / 2] - dp[sum / 2];
    }
}
