public class LeetCode879 {
    public int profitableSchemes(int n, int min, int[] gs, int[] ps) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[n + 1][min + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= gs.length; i++) {
            int g = gs[i - 1];
            int p = ps[i - 1];
            for (int j = n; j >= g; j--) {
                for (int k = min; k >= 0; k--) {
                    dp[j][k] += dp[j - g][Math.max(k - p, 0)];
                    if (dp[j][k] >= mod) dp[j][k] -= mod;
                }
            }
        }
        return dp[n][min];
    }
}
