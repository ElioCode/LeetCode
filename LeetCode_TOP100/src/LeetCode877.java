

public class LeetCode877 {
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int num : piles) {
            sum += num;
        }
        int Alex = loop(piles, 0, piles.length - 1);
        return Alex > sum / 2 ? true : false;
    }

    private int loop(int[] piles, int l, int r) {
        if (l >= r) return 0;
        int max = Math.max(piles[l], piles[r]);
        return max + max == piles[l] ? Math.max(loop(piles, l + 1, r - 1), loop(piles, l + 2, r)) :
                Math.max(loop(piles, l + 1, r - 1), loop(piles, l, r - 2));
    }
}
