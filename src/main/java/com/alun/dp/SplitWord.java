package com.alun.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SplitWord {

    public static boolean splitWord(String target, String[] dict) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        for (String str : dict) {
            stringStringHashMap.put(str, str);
        }
        boolean[] ans = new boolean[target.length() + 1];
        ans[0] = true;
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (j <= i - j) {
                    String word = target.substring(j, i - j);
                    if (stringStringHashMap.containsKey(word) && ans[j]) {
                        ans[i] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        return true;
    }

    public static boolean splitWordV2(String target, String[] dict) {
        HashMap<String, String> dictMap = new HashMap<>();
        for (String str : dict) {
            dictMap.put(str, str);
        }
        int start = 0;
        for (int i = 1; i <= target.length(); i++) {
            String word = target.substring(start, i);
            if (dictMap.containsKey(word)) {
                start = i;
            }
        }
        if (start == target.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void splitWordV3(String target, String[] dict) {
        HashMap<String, String> dictMap = new HashMap<>();
        for (String str : dict) {
            dictMap.put(str, str);
        }
        int[] dp = new int[target.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j <= i - j) {
                    String word = target.substring(j, i - j);
                    if (dictMap.containsKey(word) && dp[j] == 1) {
                        dp[i] = 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        System.out.println(splitWord("leecode", new String[]{"lee", "code"}));
        System.out.println(splitWordV2("applepenapple", new String[]{"apple", "pen"}));
        System.out.println(splitWord("catsandog", new String[]{"cats", "dog", "sand", "and", "cat"}));
        splitWordV3("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaab"});
    }
}
