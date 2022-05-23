package com.alun.sort;

import java.util.Arrays;

public class HeapSort {

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len + 1);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len--;
            maxHeapifyV2(nums, 0, i);
        }
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapifyV2(nums, i, len);
        }
    }

    private void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len; ) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }

            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }

            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void maxHeapifyV2(int[] nums, int i, int len) {
        int large = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;

        if (lson < len) {
            large = nums[lson] > nums[i] ? lson : i;
        }
        if (rson < len) {
            large = nums[rson] > nums[large] ? rson : large;
        }
        if (large != i) {
            swap(nums, i, large);
        }

    }

    private void maxHeapifyV3(int[] nums, int i, int len) {
        for (; i * 2 + 1 < len; ) {
            int lson = i * 2 + 1;
            int rson = i * 2 + 2;
            int large = i;
            if (lson < len && nums[i] < nums[lson]) {
                large = lson;
            }
            if (rson < len && nums[large] < nums[rson]) {
                large = rson;
            }
            if (i == large) {
                break;
            } else {
                swap(nums, i, large);
                i = large;
            }
        }
    }


    private void swap(int[] nums, int i, int large) {
        if (i == large) {
            return;
        }
        nums[i] = nums[i] ^ nums[large];
        nums[large] = nums[i] ^ nums[large];
        nums[i] = nums[i] ^ nums[large];
    }

    private void printArray(int[] nums) {
        Arrays.stream(nums).forEach(item -> System.out.print(item + ","));
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = new int[]{1, 6, 7, 3, 2, 9};
        int firstRoot = nums.length / 2 - 1;
        for(int i = firstRoot ; i >= 0; i--) {
            heapSort.maxHeapifyV3(nums, i, nums.length);
        }
        //heapSort.printArray(heapSort.sortArray(new int[]{1, 6, 7, 3, 2, 9}));
        System.out.println(Arrays.toString(nums));

    }
}
