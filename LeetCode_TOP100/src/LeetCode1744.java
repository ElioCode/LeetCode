public class LeetCode1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] cal = new long[n];
        cal[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            cal[i] = cal[i - 1] + candiesCount[i];
        }
        int m = queries.length;
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            long count = (queries[i][1] + 1) * queries[i][2];
            long day = queries[i][1] + 1;
            if (day <= (long) cal[queries[i][0]]) {
                if (queries[i][0] == 0 || (queries[i][0] > 0 && count > cal[queries[i][0] - 1])) {
                    res[i] = true;
                }
            }
        }
        return res;
    }
}
