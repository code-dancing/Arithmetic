package cn.com.garay.arithmetic.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 1, 0, 52, 23, 4235, 9, 10, 234, 0};

        selectSort1(arr);

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 原始选择排序
     */
    private static void selectSort(int[] arr) {
        //从第一个元素开始，共进行 arr.length - 1 轮，就是外层循环
        for (int x = 0; x < arr.length - 1; x++) {
            //内层循环比较是第一个无序元素从比较第二个无序元素开始
            for (int y = x + 1; y < arr.length; y++) {
                //如果第一个无序元素比所比元素大时，交换元素
                if (arr[x] > arr[y]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }

    /**
     * 优化的选择排序
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


}
