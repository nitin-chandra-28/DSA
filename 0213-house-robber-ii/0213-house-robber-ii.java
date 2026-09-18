class Solution {
    public int solveRec(int[] nums, int start, int end) {
        if(start > end) return 0;
        int rob = nums[start] + solveRec(nums, start + 2, end);
        int skip = solveRec(nums, start + 1, end);

        return Math.max(rob, skip);
    }
    public int solveMem(int[] nums, int start, int end, int[] dp) {
        if(start > end) return 0;
        if (dp[start] != -1) {
            return dp[start];
        }
        int rob = nums[start] + solveMem(nums, start + 2, end, dp);
        int skip = solveMem(nums, start + 1, end, dp);

        return dp[start] = Math.max(rob, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case1 = solveMem(nums,0, n - 2, dp1);
        int case2 = solveMem(nums, 1, n - 1, dp2);
        return Math.max(case1, case2);
    }
}