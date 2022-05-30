package com.alun.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

        System.out.println(reverse(new char[]{'h', 'e', 'l', 'l', 'o'}));
        Integer[] nums = new Integer[]{12, 34, 0, 4, 23, 89 };

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(Arrays.toString(nums));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    }

    public static char[] reverse(char[] chars) {
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            swap(chars, i, j);
        }
        return chars;
    }

    public static void swap(char[] chars, int left, int right) {
        if (left == right) {
            return;
        }
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }



}
