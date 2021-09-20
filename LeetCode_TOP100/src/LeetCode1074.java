import java.util.HashMap;

public class LeetCode1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int top = 1; top <= m; top++) {
            for (int bot = top; bot <= m; bot++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int cur = 0;
                for (int right = 1; right <= n; right++) {
                    cur = sum[bot][right] - sum[top - 1][right];
                    if (cur == target) {
                        res++;
                    }
                    if (map.containsKey(cur - target)) {
                        res += map.get(cur - target);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
