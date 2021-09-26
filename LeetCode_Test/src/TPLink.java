public class TPLink {
    public static void main(String[] args) {
        System.out.println(dfs(9,3,0));
    }

    static int dfs(int a, int b, int x) {
        int ans = 0;
        int i = 0;
        if (b == 1) {
            return 1;
        }
        for ( i = 0; i <= a
                ; i++) {
            ans += dfs(a - i, b - 1, i);

        }
        return ans;
    }
}
