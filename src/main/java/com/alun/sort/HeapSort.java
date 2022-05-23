package com.alun.sort;

import java.util.Arrays;

public class HeapSort {

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len--;
            maxHeapify(nums, 0, len);
        }
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
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
        heapSort.printArray(heapSort.sortArray(new int[]{1, 6, 7, 3, 2, 9}));


    }
}
