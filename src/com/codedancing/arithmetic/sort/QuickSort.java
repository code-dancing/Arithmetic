package com.codedancing.arithmetic.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 基本思想：
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 *
 *
 * 时间复杂度： O(nlogn)
 * 稳定性： 不稳定
 */
public class QuickSort {

    private static void quickSort(int[] a, int left, int right) {
        int i, j, temp, base;
        if (left > right) {
            return;
        }
        // base中存的就是基准数
        base = a[left];
        // 设置两个哨兵
        i = left;
        j = right;
        while (i != j) {
            // 顺序很重要，要先从右边开始找
            while (a[j] >= base && i < j) {
                j--;
            }
            // 再找右边的
            while (a[i] <= base && i < j) {
                i++;
            }
            // 交换两个数在数组中的位置
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // 最终将基准数归位
        a[left] = a[i];
        a[i] = base;

        // 继续处理左边的，这里是一个递归的过程
        quickSort(a, left, i - 1);
        // 继续处理右边的 ，这里是一个递归的过程
        quickSort(a, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
