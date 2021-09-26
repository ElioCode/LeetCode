public class Offer51 {
    static int res = 0;
    public static int reversePairs(int[] nums) {
        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);
        return res;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            mergeSort(nums,l,mid);
            mergeSort(nums, mid + 1, r);
            if (nums[mid] <= nums[mid + 1]) return;
            merge(nums, l, mid, r);
        }
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] copy = new int[r - l + 1];
        int index = 0;
        int t1 = l;
        int t2 = mid + 1;
        while (t1 <= mid && t2 <= r) {
            if (nums[t1] < nums[t2]) {
                copy[index++] = nums[t1++];
            } else {
                copy[index++] = nums[t2++];
                res += mid - t1 + 1;

            }
        }
        while (t1 <= mid) {
            copy[index++] = nums[t1++];
        }
        while (t2 <= r) {
            copy[index++] = nums[t2++];
        }
        for (int i = l; i <= r; i++) {
            nums[i] = copy[i - l];
        }
    }

    public static void main(String[] args) {
        int[] r = {4, 5, 6, 7};
        int t = reversePairs(r);
    }
}
