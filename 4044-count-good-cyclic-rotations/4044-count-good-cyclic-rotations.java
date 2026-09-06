class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int k = n/2;
        long Sum = 0;
        long totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];

            if(i < k) {
                Sum += nums[i];
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(2L * Sum  > totalSum) count++;
            Sum -= nums[i];
            Sum += nums[(i + k) % n];
        }
        return count;
    }
}