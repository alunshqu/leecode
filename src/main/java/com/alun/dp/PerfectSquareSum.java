package com.alun.dp;

import java.util.Arrays;

public class PerfectSquareSum {

    public static int perfectSquare(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;//初始化
        }
        for(int i = 0; i <= n; i++) {//遍历物品
            for(int j = 1; j * j<= i; j++) {//遍历背包
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return 0;
    }

    public static void main(String[] args) {
        perfectSquare(5);
    }
}
