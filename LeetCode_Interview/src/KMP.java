public class KMP {
    public static void main(String[] args) {
        String s = "ababeegbee";
        String p = "bee";
        System.out.println(getKMP(s, p));
    }
    public static int[] getNext(String p) {
        int len = p.length();
        int[] next = new int[len];
        next[0] = -1;
        int i = 0,j = -1;
        while (i < len - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                if (p.charAt(++i) == p.charAt(++j)) {
                    next[i] = next[j];
                } else {
                    next[i] = j;
                }

            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int getKMP(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || ss[i] == ps[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length()) return i - j;
        return -1;
    }
}
