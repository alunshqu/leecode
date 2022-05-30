package com.alun.dp;

import java.util.Arrays;

public class Fibonacci {

    public static int[] fibonacci(int n) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp;
    }

    public static int fibonacciV2(int n) {
        int a = 0;
        int b = 1;
        for(int i = 2; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacci(10)));
        System.out.println(fibonacciV2(10));
        System.out.println(Arrays.toString(fibonacci(30)));
        System.out.println(fibonacciV2(30));
    }
}
