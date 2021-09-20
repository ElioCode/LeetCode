public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[m][n];
    }
}
