import java.util.PriorityQueue;

public class LeetCode1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] xor = new int[m + 1][n + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if (queue.size() < k) {
                    queue.add(xor[i][j]);
                } else if (xor[i][j] > queue.peek()) {
                    queue.poll();
                    queue.add(xor[i][j]);
                }
            }
        }
        return queue.peek();
    }
}
