public class LeetCode1442 {
    public int countTriplets(int[] arr) {
        int[] preXOR = new int[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            preXOR[i] = arr[i - 1] ^ preXOR[i - 1];
        }
        int res = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = i + 1; j < arr.length + 1; j++) {
                if (preXOR[i - 1] == preXOR[j]) res += j - i;
            }
        }
        return res;
    }
}
