package com.alun.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    static Map<Integer, Integer> map = new HashMap<>();

    public static int numWays(int step) {
        if (step == 1) {
            return 1;
        } else if (step == 2) {
            return 2;
        }
        if (!map.containsKey(step)) {
            map.put(step, numWays(step - 1) + numWays(step - 2));
        }
        return map.get(step);
    }

    public static int numWaysV2(int step) {
        if (step == 1) {
            return 1;
        } else if (step == 2) {
            return 2;
        }
        int firstStep = 1;
        int secondStep = 2;
        int result = 0;
        for (int i = 3; i <= step; i++) {
            result = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = result;
        }
        return result;
    }


    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int l : dp) {
            l = 1;
        }
        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i] && dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(numWays(31));
        System.out.println(numWaysV2(31));

        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
