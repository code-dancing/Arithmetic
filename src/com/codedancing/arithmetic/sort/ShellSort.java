package com.codedancing.arithmetic.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * 基本思想：
 * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。
 * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
 *
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
 *
 *
 * 时间复杂度： O(n)～O(nlog2n)
 * 稳定性： 不稳定
 */
public class ShellSort {

    private static void shellSort(int[] a) {
        int n = a.length;
        int j;
        /* 希尔增量序列，增量gap，并逐步缩小增量 */
        for (int gap = n / 2; gap > 0; gap /= 2) {
            /* 插入排序，从第gap个元素，逐个对其所在组进行直接插入排序操作 */
            for (int p = gap; p < n; p++) {
                int temp = a[p];
                for (j = p; j >= gap && a[j - 1] > temp; j = j - gap) {
                    // 移动元素
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
