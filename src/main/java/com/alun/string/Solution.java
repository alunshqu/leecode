package com.alun.string;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        //记录字符出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        int length = s.length();
        int res = 0; //窗口大小
        int start = 0; // 窗口开始的位置
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbbcdefghiaabbdefghi"));
        System.out.println(lengthOfLongestSubstring("bbb"));
    }

}
