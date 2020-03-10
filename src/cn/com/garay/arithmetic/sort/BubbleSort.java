package cn.com.garay.arithmetic.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 原始版本
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 第一种优化冒泡排序
     */
    private static void bubbleSort1(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 第二种优化冒泡排序
     */
    private static void bubbleSort2(int[] arr) {
        int len = arr.length;
        int flag = len - 1;
        // 如果flag<=0则排序结束
        while (flag > 0) {
            flag = 0;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    // 设置新边界
                    flag = i + 1;
                }
            }
            // 记录遍历的边界
            len = flag;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 1, 0, 52, 23, 4235, 9, 10, 234, 0};
        //bubbleSort1(arr);
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

}
