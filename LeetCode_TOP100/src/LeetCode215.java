
import java.util.PriorityQueue;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k);
    }

    private int heapSort(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int top = heap.peek();
            if (nums[i] > top) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }

    private int quickSort(int[] nums, int k) {
        int right = nums.length - 1;
        int left = 0;
        int index = right - k + 1;
        while (true) {
            int patiton = patition(nums, left, right);
            if (patiton == index) {
                return nums[index];
            } else if (patiton > index) {
                right = patiton - 1;
            } else {
                left = patiton + 1;
            }
        }

    }

    private int patition(int[] nums, int left, int right) {
        int mid = (left+right)/2;
        swap(nums, left, mid);
        int j = left;
        int pivot = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
