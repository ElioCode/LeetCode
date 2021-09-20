public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int k = (i + j) / 2;
                if (nums[k] > num) {
                    j = k;
                } else {
                    i = k + 1;
                }
            }
            tail[i] = num;
            if (i == res) res++;
        }
        return res;
    }
}
