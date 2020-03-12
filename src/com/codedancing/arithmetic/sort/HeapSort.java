package com.codedancing.arithmetic.sort;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * 利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 1. 大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
 * 2. 小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
 * <p>
 * 时间复杂度：Ο(nlogn)
 * 稳定性：不稳定
 */
public class HeapSort {

    private static void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //2.调整堆结构并交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            //将堆顶元素与末尾元素进行交换
            swap(arr, 0, j);
            //重新对堆进行调整
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始（i是该元素的数组中的下标，2i+1是左子节点元素，2i+2是右子节点元素）
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    /**
     * 交换元素
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 100, 4, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
