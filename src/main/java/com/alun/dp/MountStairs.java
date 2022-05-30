package com.alun.dp;

public class MountStairs {

    public static int climbStairs(int m, int n) {
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[m];
    }

    public static int climbStairsV2(int m) {
        int a = 1;
        int b = 2;
        for (int i = 3; i <= m; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10, 5));
        System.out.println(climbStairsV2(10));
    }
}
