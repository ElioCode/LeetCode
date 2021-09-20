

public class LeetCode740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] bucket = new int[max + 1];
        for (int num : nums) {
            bucket[num]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = bucket[1];
        int res = 0;
        for (int i = 2; i < bucket.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * bucket[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
