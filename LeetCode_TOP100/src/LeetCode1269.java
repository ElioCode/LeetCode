public class LeetCode1269 {
    public int numWays(int steps, int arrLen) {
        int mod = (int) (1e9 + 7);
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[steps + 1][max + 1];
        dp[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            int edge = Math.min(max, i);
            for (int j = 0; j <= edge; j++) {
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
                if (j + 1 <= max) dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
                if (j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
            }
        }
        return dp[0][0];
    }
}
