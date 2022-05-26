package com.alun.stack;

import java.util.Arrays;
import java.util.Stack;

public class TemperatureAnalyze {

    public static int[] temperatureAnalyze(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(temperatureAnalyze(new int[]{30, 23, 25, 28, 32, 29})));
        System.out.println(Arrays.toString(temperatureAnalyze(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(temperatureAnalyze(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(temperatureAnalyze(new int[]{30, 60, 90})));
    }
}
