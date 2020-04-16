package com.codedancing.arithmetic.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入，如果碰见一个和插入元素相等的元素，那么插入在相等元素的后面。
 *
 * 优化思路：如果数据量比较大，在直接插入排序的基础上，为了减少关键码的比较次数，可以使用折半插入来寻找要插入的位置，先找中间位置，比较中间值，看向前还是向后遍历插入元素
 *
 * 时间复杂度：O(n^2）
 * 稳定性：稳定
 */
public class InsertionSort {

    private static void insertSort(int[] a) {
        //　从第二个元素开始，依次向前比较，需要（a.length - 1）次
        for (int i = 1; i < a.length; i++) {
            int j;
            // 待插入的元素
            int target = a[i];
            // 该元素依次向前比较，将前面较大的元素向后移动
            for (j = i - 1; j >= 0 && target < a[j]; j--) {
                a[j + 1] = a[j];
            }
            //　target到达插入位置
            a[j + 1] = target;
        }
    }


    public static void main(String[] args) {
        int[] arr = {213, 4, 65, 3, 6, 85};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
