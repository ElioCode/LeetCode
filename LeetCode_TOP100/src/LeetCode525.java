import java.util.HashMap;
import java.util.Map;

public class LeetCode525 {
    public int findMaxLength(int[] nums) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                res = Math.max(i - map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
