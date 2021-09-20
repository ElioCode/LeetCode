public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robIndex(nums, 0, nums.length - 2),
                robIndex(nums, 1, nums.length - 1));
    }

    private int robIndex(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }else{
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start], nums[start+1]);
            for (int index = 2; index < end - start + 1; index++) {
                dp[index] = Math.max(nums[start + index] + dp[index - 2], dp[index - 1]);
            }
        }
        return dp[end - start];
    }
}
