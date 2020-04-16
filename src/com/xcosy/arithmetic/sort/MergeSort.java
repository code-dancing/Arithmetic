package com.codedancing.arithmetic.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 基本思想：
 * 采用分治法（Divide and Conquer）, 将已有序的子序列合并, 得到完全有序的序列；即先使每个子序列有序, 再使子序列段间有序。若将两个有序表合并成一个有序表, 称为2-路归并
 * 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * 时间复杂度： O(nlog2n)
 * 稳定性： 稳定
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, arr.length - 1);
    }

    /**
     * 归并排序
     *
     * @param arr        排序数组
     * @param tempArr    临时存储数组
     * @param startIndex 排序起始位置
     * @param endIndex   排序终止位置
     */
    private static void sort(int[] arr, int[] tempArr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        // 中部下标
        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        // 分解
        sort(arr, tempArr, startIndex, middleIndex);
        sort(arr, tempArr, middleIndex + 1, endIndex);

        // 归并
        merge(arr, tempArr, startIndex, middleIndex, endIndex);
    }

    /**
     * 归并
     *
     * @param arr         排序数组
     * @param tempArr     临时存储数组
     * @param startIndex  归并起始位置
     * @param middleIndex 归并中间位置
     * @param endIndex    归并终止位置
     */
    private static void merge(int[] arr, int[] tempArr, int startIndex, int middleIndex, int endIndex) {
        //复制要合并的数据
        for (int s = startIndex; s <= endIndex; s++) {
            tempArr[s] = arr[s];
        }

        // 左边首位下标
        int left = startIndex;
        // 右边首位下标
        int right = middleIndex + 1;
        for (int k = startIndex; k <= endIndex; k++) {
            if (left > middleIndex) {
                // 如果左边的首位下标大于中部下标, 证明左边的数据已经排完了。
                arr[k] = tempArr[right++];
            } else if (right > endIndex) {
                // 如果右边的首位下标大于了数组长度, 证明右边的数据已经排完了。
                arr[k] = tempArr[left++];
            } else if (tempArr[right] < tempArr[left]) {
                // 将右边的首位排入, 然后右边的下标指针+1。
                arr[k] = tempArr[right++];
            } else {
                // 将左边的首位排入, 然后左边的下标指针+1。
                arr[k] = tempArr[left++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
