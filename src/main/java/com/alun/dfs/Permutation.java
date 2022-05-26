package com.alun.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public void permutation(int[] nums, int index, int len) {
        if (index == len) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = index; i < len; i++) {
            swap(nums, i, index);
            permutation(nums, index + 1, len);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        permutationV2(nums, track, answer);
        return answer;
    }

    public void permutationV2(int[] nums, LinkedList<Integer> track, List<List<Integer>> answer) {
        if (track.size() == nums.length) {
            answer.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            permutationV2(nums, track, answer);
            track.removeLast();
        }
    }

    public List<String> permuteString(String str) {
        int len = str.length();
        boolean[] visited = new boolean[len];
        char[] charArrays = str.toCharArray();
        Arrays.sort(charArrays);
        StringBuffer sb = new StringBuffer();
        List<String> answer = new LinkedList<>();
        dfsPermuteString(charArrays, 0, len ,sb, visited, answer);
        return answer;
    }

    private void dfsPermuteString(char[] charArrays, int index, int length,StringBuffer sb, boolean[] visited, List<String> answer) {
        if(index == length) {
            answer.add(sb.toString());
            return;
        }
        for(int i = 0; i < length; i++) {
            if(visited[i] || (i > 0 && !visited[i - 1] && charArrays[i - 1] == charArrays[i])) {
                continue;
            }
            visited[i] = true;
            sb.append(charArrays[i]);
            dfsPermuteString(charArrays, index + 1, length, sb, visited, answer);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Permutation permutation = new Permutation();
        //permutation.permutation(nums, 0, nums.length);

        System.out.println(permutation.permuteString("abbcd"));
    }
}
