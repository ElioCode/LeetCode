public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int INF = 0x3f3f3f3f;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }
        for (int i = 1; i <= coins.length; i++) {
            int x = coins[i - 1];
            for (int j = x; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }

}
