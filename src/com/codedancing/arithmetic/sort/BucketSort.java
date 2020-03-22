package com.codedancing.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序
 *
 * 基本思想：
 * 将要排的数据分到多个有序的桶里，每个桶里的数据再单独排序，再把每个桶的数据依次取出，即可完成排序。
 * 在额外空间充足的情况下，尽量增大桶的数量，极限情况下每个桶只有一个数据时，或者是每只桶只装一个值时，完全避开了桶内排序的操作，桶排序的最好时间复杂度就能够达到 O(n)。
 *
 * 时间复杂度： O(n) ~ O(n^2)
 * 稳定性： 稳定
 */
public class BucketSort {

    public static void bucketSort(int[] arr) {
        //最大最小值
        int max = arr[0];
        int min = arr[0];
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        //最大值和最小值的差
        int diff = max - min;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            bucketList.add(new ArrayList<>());
        }

        //每个桶的存数区间
        float section = (float) diff / (float) (length - 1);

        //数据入桶
        for (int i = 0; i < length; i++) {
            //当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;
            if (num < 0) {
                num = 0;
            }
            bucketList.get(num).add(arr[i]);
        }

        //桶内排序
        for (int i = 0; i < bucketList.size(); i++) {
            //jdk的排序速度当然信得过
            Collections.sort(bucketList.get(i));
        }

        //写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                arr[index] = value;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
