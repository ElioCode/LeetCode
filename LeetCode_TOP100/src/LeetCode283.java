public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                if (r > l) {
                    nums[l] = nums[r];
                    nums[r] = 0;
                }
                l++;
            }
            r++;
        }
    }
}
