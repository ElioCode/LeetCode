public class LeetCode91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if (s.charAt(0) > '0' && s.charAt(0) <= '9') dp[1] = 1;
        else return 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                dp[i + 1] = dp[i];
                if (s.charAt(i - 1) != '0') {
                    String tmp = String.valueOf(s.charAt(i - 1)) + String.valueOf(s.charAt(i));
                    if (tmp.compareTo("26") <= 0 && tmp.compareTo("10") >= 0) {
                        dp[i + 1] += dp[i - 1];
                    }
                }
            }
        }
        return dp[n];
    }
}
