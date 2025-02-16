package array;

// array, binary search
public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        if (left == right) return nums[left] == target ? left : -1;
        int mid = (right + left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        }
        return binarySearch(nums, target, mid + 1, right);
    }
}
