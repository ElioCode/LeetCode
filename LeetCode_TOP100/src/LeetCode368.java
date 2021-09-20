import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        index[0] = -1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            int tmp = 0;
            index[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] > tmp) {
                    tmp = dp[j];
                    index[i] = j;
                }
            }
            dp[i] += tmp;
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = dp[i] > dp[max] ? i : max;
        }
        while (max >= 0) {
            res.add(nums[max]);
            max = index[max];
        }
        return res;
    }
}
