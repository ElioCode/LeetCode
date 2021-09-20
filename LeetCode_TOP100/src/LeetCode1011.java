

public class LeetCode1011 {
    public static int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int sum = 0;
        for (int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }
        int l = max, r = sum;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(weights, D, mid)) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    private static boolean check(int[] weights, int D, int T){
        int sum = 0;
        int count = 0;
        for (int i = 0; i < weights.length;sum = 0, count++) {
            while (i < weights.length && sum + weights[i] <= T) {
                sum += weights[i];
                i++;
            }
        }
        return count <= D;
    }

    public static void main(String[] args) {
        int i = shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.println(i);
    }
}
