package com.codedancing.arithmetic.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止，相比冒泡排序，减少了元素的移动次数。
 *
 * 时间复杂度：O(n^2)
 * 稳定性：不稳定
 */
public class SelectionSort {

    /**
     * 原始选择排序
     */
    private static void selectSort(int[] arr) {
        //从第一个元素开始，共进行 arr.length - 1 轮，就是外层循环
        for (int x = 1; x <= arr.length - 1; x++) {
            //内层循环比较是第一个无序元素从比较第二个无序元素开始
            for (int y = x; y < arr.length; y++) {
                //如果首元素比所比较元素大时，交换元素
                if (arr[x-1] > arr[y]) {
                    int temp = arr[x-1];
                    arr[x-1] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }

    /**
     * 优化选择排序
     */
    private static void selectSort1(int[] arr) {
        //与之前一样，外层循环确定轮数，共有arr.length-1 轮
        for (int x = 0; x < arr.length - 1; x++) {
            //将每轮开始的元素值赋给栈内存的num
            int num = arr[x];
            int index = x;
            //将每轮开始元素的下标赋给栈内存的index，与之前一样，内层循环确定比较次数
            for (int y = x + 1; y < arr.length; y++) {
                //如果比较过程中，num的值比所比较的值大，则用较小值刷新num的值，并将下标赋给index
                if (num > arr[y]) {
                    num = arr[y];
                    index = y;
                }
            }
            //减少判断 如果每轮的第一个元素就是此轮比较的最小值 那么他不用和自己交换，如果不同，则交换
            if (index != x) {
                int temp = arr[index];
                arr[index] = arr[x];
                arr[x] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 1, 0, 52, 23, 4235, 9, 10, 234, 0};
        selectSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

}
