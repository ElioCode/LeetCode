import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
    public int numSquares(int n) {
        List<Integer> nums = squre(n);
        int[] dp = new int[n + 1];
        // for (int j = 0; j <= n; j++) {
        //     int t = nums.get(0);
        //     int k = j / t;
        //     if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
        //         dp[j] = k;
        //     } else { // 其余则为无效值
        //         dp[j] = Integer.MAX_VALUE;
        //     }
        // }
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i); j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - nums.get(i)] + 1);
                // if(dp[j - nums.get(i)] != Integer.MAX_VALUE){
                //     dp[j] = Math.min(dp[j], dp[j - nums.get(i)] + 1);
                // }
            }
        }
        return dp[n];

    }

    private List<Integer> squre(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(n) + 1; i++) {
            if (i * i <= n) {
                res.add(i * i);
            }
        }
        return res;
    }
}
