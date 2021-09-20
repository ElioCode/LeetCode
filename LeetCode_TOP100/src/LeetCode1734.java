public class LeetCode1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        int a = 0;
        for (int i = 0; i < n - 1; i = i + 2) {
            a ^= encoded[i];
        }
        int b = 0;
        for (int i = 1; i <= n; i++) {
            b ^= i;
        }
        res[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            res[i] ^= encoded[i] ^ res[i + 1];
        }
        return res;
    }
}
