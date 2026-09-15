class Solution {
    public int solveMem(int[] coins, int n, int s, int[][] dp) {
        if(s == 0) {
            return 1;
        }
        if(s < 0 || n == 0) {
            return 0;
        }

        if (dp[n][s] != -1) return dp[n][s];
        dp[n][s] = solveMem(coins, n - 1, s, dp) + solveMem(coins, n, s - coins[n - 1], dp);

        return dp[n][s];

    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solveMem(coins, n, amount, dp);
    }
}