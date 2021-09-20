public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        int preMax = nums[0];
        int preMin = nums[0];
        int res = nums[0];

        int curMax;
        int curMin;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(nums[i], nums[i] * preMax);
                curMin = Math.min(nums[i], nums[i] * preMin);
            }else {
                curMax = Math.max(nums[i], nums[i] * preMin);
                curMin = Math.min(nums[i], nums[i] * preMax);
            }

            res = Math.max(res, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
