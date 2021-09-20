

public class LeetCode1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return check(bloomDay, l, m, k) ? l : -1;
    }

    public static boolean check(int[] nums, int mid, int m, int k) {
        int cur = 0, j = 0, count = 0;
        for (int i = 0; i < nums.length; ) {
            cur = nums[i] > mid ? 0 : 1;
            j = i;
            if (cur > 0) {
                while (cur < k && j + 1 < nums.length && nums[j + 1] <= mid) {
                    cur++;
                    j++;
                }
                if (cur == k) count++;
                i = j + 1;
            } else {
                i++;
            }
        }
        return count >= m;

    }
}
