package cn.wkq.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: weikeqin.cn@gmail.com
 * @date: 2018-06-03 19:52
 */
public class MergeSort {

    /**
     * 归并排序 迭代法
     *
     * @author weikeqin.cn@gmail.com
     */
    public static int[] mergeSortBottomUp(int[] arr) {

        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;

        return result;
    }

    /**
     *
     * @param arr 要排序的数组
     * @param result 保存排序结果的数组
     * @param start 开始位置
     * @param end 结束位置
     *
     * @author weikeqin.cn@gmail.com
     * @date 2018-06-03 21:00
     */
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {

        if (start >= end) {
            return;
        }

        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    /**
     * 归并排序 递归版
     *
     * @param arr
     * @author weikeqin.cn@gmail.com
     * @date 2018-06-03 20:41
     */
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4, -3};
        System.out.println(Arrays.toString(nums));
    }



    @Test
    public void test2(){
        int i = 4;
        System.out.println(i<<1);
        System.out.println(i>>1);
    }

}
