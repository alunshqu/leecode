package com.alun.dfs;

public class Board {
    int count = 0;

    public void dfs(int[][] nums, int i, int j, int len, int height) {
        if (i == len - 1 && j == height - 1) {
            count++;
            return;
        }
        //right
        if(i + 1 < len) {
            dfs(nums, i + 1, j, len, height);
        }

        if(j + 1 < height) {
            dfs(nums, i, j + 1, len, height);
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[10][10];
        Board board = new Board();
        board.dfs(nums, 0, 0, 10, 10);
        System.out.println(board.count);
    }


}
