public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if (needle == null) return 0;
        int needleLength = needle.length();
        char start = needle.charAt(0);
        for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
            if (haystack.charAt(i) == start) {
                if (haystack.substring(i, i + needleLength).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int KMP(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int m = haystack.length();
        int n = needle.length();
        String ss = " " + haystack;
        String nn = " " + needle;
        int[] next = new int[n + 1];
        for (int i = 2, j = 0; i < n + 1; i++) {
            while (j > 0 && nn.charAt(i) != nn.charAt(j + 1)) {
                j = next[j];
            }
            if (nn.charAt(i) == nn.charAt(j + 1)) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i < m + 1; i++) {
            while (j > 0 && ss.charAt(i) != nn.charAt(j + 1)) {
                j = next[j];
            }
            if (ss.charAt(i) == nn.charAt(j + 1)) j++;
            if (j == n) return i - n;
        }
        return -1;
    }
}
