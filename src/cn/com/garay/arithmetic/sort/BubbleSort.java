package cn.com.garay.arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 基本思想：
 * 重复地走访过要排序的元素，依次比较相邻两个元素，如果它们的顺序错误就把它们调换过来，直到没有元素再需要交换，排序完成。
 * 这个算法的名字由来是因为越小(或越大)的元素会经由交换慢慢“浮”到数列的顶端，简称 冒泡排序 。
 *
 * 时间复杂度：O(n) ～ O(n^2)
 * 稳定性：稳定
 */
public class BubbleSort {

    /**
     * 原始版本
     */
    private static void bubbleSort(int[] arr) {
        // 比较次数，比较（arr.length - 1）次
        int count;
        for (count = 1; count <= arr.length - 1; count++) {
            // 相邻两个数依次比较
            for(int j = 0; j < arr.length - count; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("循环次数：" + (count - 1));
    }

    /**
     * 优化冒泡排序1
     *
     * 例如 12345987， 其中12345已经排好序列，但是上面这种排序方式还是会进行比较，这样会造成不必要的时间浪费。
     *
     * 改进：设置一个标志flag，如果发生了数据交换则flag=true，否则为false排序结束。
     *
     */
    private static void bubbleSort1(int[] arr) {
        int count;
        boolean flag = true;
        for (count = 1; count <= arr.length - 1 && flag; count++) {
            flag = false;
            for (int j = 0; j < arr.length - count; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("循环次数：" + (count - 1));
    }

    /**
     * 优化冒泡排序2
     *
     * 假如现在有一个长度10000的数组，前1000无序，后9000有序并且大于前1000数据。
     * 用第一种优化方法，数据交换次数在1000之内，但是剩下9000的数据虽然没有交换，但是每次循环都会进行比较。剩下9000数据已经有序了，我们不要对它们去进行判断浪费不必要的时间。
     *
     * 改进：还是设置flag，如果进行的数据交换，那么用flag设置边界，这样后面的数据就不会进行判断比较了。
     *
     */
    private static void bubbleSort2(int[] arr) {
        int len = arr.length;
        int flag = len - 1;
        int count = 0;

        // 如果 flag<=0 则排序结束
        while (flag > 0) {
            flag = 0;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    // 如果交换位置则设置新边界
                    flag = i + 1;
                }
            }
            // 记录遍历的边界，相当于缩小了排序范围
            len = flag;
            count++;
        }

        System.out.println("循环次数：" + (count - 1));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,4,5,6,7,8,9};
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

}
