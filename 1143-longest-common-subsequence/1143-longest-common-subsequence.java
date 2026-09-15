class Solution {
    public int solveMem(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + solveMem(s1, s2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(solveMem(s1, s2, n - 1, m, dp), solveMem(s1, s2, n, m - 1,dp));
        }
        return dp[n][m];

    }
    public int solveMem(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for(int[] rows : dp) {
            Arrays.fill(rows,0);
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m;j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return solveMem(text1, text2, n, m);
    }
}