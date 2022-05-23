package com.alun.search;

import java.util.Arrays;

public class UnionSearch {
    int[] father;
    int[] rank;

    public UnionSearch(int n) {
        father = new int[n];
        rank = new int[n];
        for (int i = 1; i < n; ++i) {
            father[i] = i;
            rank[i] = 1;
        }
    }

    int find(int target) {
        if(target == father[target]) {
            return target;
        }
        return find(father[target]);
    }

    void merge(int orig, int target) {
        int x = find(orig), y = find(target);
        father[y] = x;
    }

    public static void main(String[] args) {
        UnionSearch unionSearch = new UnionSearch(7);
        unionSearch.merge(1, 2);
        unionSearch.merge(1, 5);
        unionSearch.merge(3, 4);
        unionSearch.merge(5, 2);
        unionSearch.merge(1, 3);

        System.out.println(Arrays.toString(unionSearch.father));

        System.out.println(unionSearch.find(1) + ":" + unionSearch.find(4));
        System.out.println(unionSearch.find(2) + ":" + unionSearch.find(3));
        System.out.println(unionSearch.find(5) + ":" + unionSearch.find(6));

    }

}
