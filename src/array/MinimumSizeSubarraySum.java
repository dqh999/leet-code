package array;

public class MinimumSizeSubarraySum {
    private static final int MAX_VALUE = 0x7fffffff;

    public static int minSubArrayLenSW(int target, int[] nums) {
        int left = 0, tempSum = 0, minLength = MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            while (tempSum >= target) {
                minLength = Math.min(minLength, i - left + 1);
                tempSum -= nums[left];
                left++;
            }
        }
        return minLength == MAX_VALUE ? 0 : minLength;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int result = minSubArrayLenDc(target, nums, 0, nums.length - 1);
        return result == MAX_VALUE ? 0 : result;
    };

    private static int minSubArrayLenDc(int target, int[] nums, int left, int right) {
        if (left > right) return MAX_VALUE;
        if (left == right) return nums[left] >= target ? 1 : MAX_VALUE;

        int mid = (left + right) / 2;
        int leftMin = minSubArrayLenDc(target, nums, left, mid);
        int rightMin = minSubArrayLenDc(target, nums, mid + 1, right);

        int crossMin = MAX_VALUE, leftSum = 0, rightSum = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            if (leftSum >= target) {
                crossMin = Math.min(crossMin, mid - i + 1);
            }
        }
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            if (rightSum >= target) {
                crossMin = Math.min(crossMin, i - mid);
            }
        }

        int combinedLenMin = MAX_VALUE, combinedSum = 0;
        for (int i = mid; i >= left; i--) {
            combinedSum += nums[i];
            int tempSum = combinedSum;
            for (int j = mid + 1; j <= right; j++) {
                tempSum += nums[j];
                if (tempSum >= target) {
                    combinedLenMin = Math.min(combinedLenMin, j - i + 1);
                    break;
                }
            }
        }
        return Math.min(Math.min(leftMin, rightMin), Math.min(crossMin, combinedLenMin));
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen2(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen2(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }
}
