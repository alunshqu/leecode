package com.alun.dp;

import java.util.Arrays;

public class MinimumCost {
    public static int minimumCost(int[] costs) {
        int len = costs.length;
        int[] dp = new int[len];
        dp[0] = costs[0];
        dp[1] = costs[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + costs[i];
        }
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    public static int minimumCostV2(int[] costs) {
        int len = costs.length;
        int a = costs[0];
        int b = costs[1];
        for (int i = 2; i < len; i++) {
            int min = Math.min(a, b) + costs[i];
            a = b;
            b = min;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minimumCostV2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}
