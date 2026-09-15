import java.util.*;

class Solution {
    public int solveTab(int[] coins, int n, int s) {

        int[][] dp = new int[n + 1][s + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= s; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][s];
    }


    public int change(int amount, int[] coins) {

        int n = coins.length;

        return solveTab(coins, n, amount);
    }
}