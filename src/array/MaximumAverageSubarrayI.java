package array;


public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i=0;i<k;i++) windowSum += nums[i];
        int maxSum = windowSum;
        for (int i=k;i<nums.length;i++){
            windowSum = windowSum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,windowSum);
        }
        return (double) maxSum / k;
    }
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));

    }
}
