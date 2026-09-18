class Solution {
    public int solveRec(int[] cost, int i) {
        if(i == 0) return cost[i];
        if(i == 1) return cost[i];

        int oneStep = solveRec(cost, i - 1);
        int twoStep = solveRec(cost, i - 2);

        return cost[i] + Math.min(oneStep, twoStep);
    }
    public int solveMem(int[] cost, int i, int[] dp) {
        if(i == 0) return cost[i];
        if(i == 1) return cost[i];

        if(dp[i] != -1) return dp[-1];
        int oneStep = solveMem(cost, i - 1, dp);
        int twoStep = solveMem(cost, i - 2, dp);

        return dp[i] = cost[i] + Math.min(oneStep, twoStep);
    }
    public int solveTab(int[] cost, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            int oneStep = dp[i - 1] + cost[i - 1];
        int twoStep = dp[i - 2] + cost[i - 2];

        dp[i] = Math.min(oneStep, twoStep);
        }
        return dp[n];
        
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return solveTab(cost, n);
    }
}