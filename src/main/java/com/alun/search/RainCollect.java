package com.alun.search;

import java.util.Stack;

public class RainCollect {

    public static int rainCollect(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = nums[0];
        rightMax[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for (int i = 0; i < len; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - nums[i];
        }
        return ans;
    }

    public static int rainCollectV2(int[] nums) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            while (!st.empty() && nums[i] > nums[st.peek()]) {
                int top = st.pop();
                if(st.empty()) {
                    break;
                }
                int left = st.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(nums[left], nums[i]) - nums[top];
                ans += curHeight * curWidth;
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rainCollect(new int[]{2, 0, 4, 6, 8, 2, 7}));
        System.out.println(rainCollectV2(new int[]{2, 0, 4, 6, 8, 2, 7}));
        System.out.println(rainCollect(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(rainCollectV2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(rainCollect(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(rainCollectV2(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
