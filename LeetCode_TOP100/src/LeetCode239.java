import java.util.*;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.peekLast()){
                queue.pollLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == queue.peekFirst()) queue.pollFirst();
            while (!queue.isEmpty() && nums[i] > queue.peekLast()){
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }
}
