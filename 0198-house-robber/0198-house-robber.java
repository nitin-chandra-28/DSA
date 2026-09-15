class Solution {

    public int rob(int[] money) {

        int n = money.length;

        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {

            int include = money[i] + dp[i + 2];
            int exclude = dp[i + 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[0];
    }
}