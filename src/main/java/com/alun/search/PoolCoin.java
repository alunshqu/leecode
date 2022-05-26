package com.alun.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PoolCoin {

    public List<List<Integer>> poolCoin(int[] coins, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[coins.length];
        helper(coins, 0, target, path, visited, answer);
        return answer;
    }

    private void helper(int[] coins, int cur, int target, LinkedList<Integer> path, boolean[] visited, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = cur; i < coins.length; i++) {
            if (!visited[i] && target >= coins[i]) {
                path.add(coins[i]);
                target -= coins[i];
                visited[i] = true;
                helper(coins, cur + 1, target, path, visited, answer);
                path.removeLast();
                target += coins[i];
                visited[i] = false;
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
       /* PoolCoin poolCoin = new PoolCoin();
        int[] coins = new int[]{5, 2, 1};
        //System.out.println(poolCoin.poolCoin(coins, 11));

        System.out.println(poolCoin.coinChange(coins, 11));*/

        int mode = 1_000_000_007;
        int modeV2 = 1000000007;
        System.out.println(mode == modeV2);
    }
}
