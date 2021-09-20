public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        int res = 0;
        for (int i = m; i > 0; i -= lowbit(i)) {
            res++;
        }
        return res;
    }

    private int lowbit(int x) {
        return x & -x;
    }
}
