package com.alun.dp;

import java.util.Arrays;

public class Plunder {

    public static int plunder(int[] costs, int start, int end) {
        int dp[] = new int[costs.length];
        //dp[i] 考虑下表i以内的房屋最多偷窃金额为dp[i]
        //确定递推公式 dp[i] = max(dp[i - 2] + costs[i], dp[i - 1])
        //初始化
        dp[start] = costs[start];
        dp[start + 1] = Math.max(dp[start], dp[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + costs[i], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[end];
    }

    public static int plunderV2(int[] costs) {
        int result1 = plunder(costs, 0, costs.length - 2);
        int result2 = plunder(costs, 1, costs.length - 1);
        return Math.max(result1, result2);
    }

    public static void main(String[] args) {
        System.out.println(plunderV2(new int[]{2, 7, 9, 3, 1}));
        System.out.println(plunderV2(new int[]{1, 2, 3, 1}));
    }
}
