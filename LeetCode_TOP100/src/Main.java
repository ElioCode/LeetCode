import java.util.Scanner;

//第二题
public class Main {
    public static int d() {
        Scanner sc = new Scanner(System.in);
        int C = Integer.parseInt(sc.nextLine());
        String[] s1 = sc.nextLine().split(",");
        String[] s2 = sc.nextLine().split(",");
        int n = s1.length;
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(s1[i]);
            v[i] = Integer.parseInt(s2[i]);
        }
        int[] f = new int[C + 1];
        for (int i = 1; i <= n; i++) {
            int weight = w[i - 1];
            int value = v[i - 1];
            for (int j = C; j >= weight; j --) {
                f[j] = Math.max(f[j], f[j - weight] + value);
            }
        }
        return f[C];
    }

    public static void main(String[] args) {
        System.out.println(d());
    }
}
