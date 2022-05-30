package com.alun.dp;

import java.util.Arrays;

public class BreakNum {

    public static int breakNum(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for(int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(breakNum(10));
    }
}
