import java.util.HashMap;

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i);
            }else{
                int pre = map.get(sum % k);
                if (i - pre > 1) return true;
            }
        }
        return false;
    }
}
