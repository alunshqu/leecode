package com.alun.dp;

import java.util.Arrays;

public class UniquePath {

    public static int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return 0;
    }

    public static int uniquePath(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return 0;

    }

    public static void main(String[] args) {
        uniquePath(3, 7);

        uniquePath(new int[][]{
                {
                        0, 0, 0, 0, 1, 0, 0
                }, {
                1, 0, 0, 0, 0, 1, 1
        }, {
                0, 0, 0, 0, 1, 0, 0
        }
        });
    }
}
