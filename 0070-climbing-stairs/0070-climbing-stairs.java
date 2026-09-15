class Solution {
    public int solveMem(int n, int[] dp) {
         if(n == 0){
            return 1;
        }
        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        dp[n] = solveMem(n - 1, dp) + solveMem(n - 2, dp);
        return dp[n];
    }
    public int climbStairs(int n) {
       int[] dp = new int[n + 1];
       Arrays.fill(dp, -1);
       return solveMem(n, dp);
    }
}