public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[] tmp = new int[2];
        for (String s : strs) {
            tmp = cal(s);
            for (int i = m; i >= tmp[0]; i--) {
                for (int j = n; j >= tmp[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - tmp[0]][j - tmp[1]] + 1);
                }
            }
        }
        return dp[m][n];

    }

    private int[] cal(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res[1]++;
            } else {
                res[0]++;
            }
        }
        return res;
    }
}
