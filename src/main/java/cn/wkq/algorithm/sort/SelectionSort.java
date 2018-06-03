package cn.wkq.algorithm.sort;

import java.util.Arrays;

/**
 * 简单选择排序
 *
 * https://www.cnblogs.com/chengxiao/p/6103002.html
 *
 * @author: weikeqin.cn@gmail.com
 */
public class SelectionSort {

    /**
     * 简单选择排序<br>
     *
     *  <pre>
     *     基本思想: 为每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，
     *              直到所有元素排完为止。
     *
     *  原始数据    2  7  8  2  7  6  1  3  0
     *  第一次交换  0  7  8  2  7  6  1  3  2
     *  第二次交换  0  1  8  2  7  6  7  3  2
     *  第三次交换  0  1  2  8  7  6  7  3  2
     *  第四次交换  0  1  2  2  7  6  7  3  8
     *  第五次交换  0  1  2  2  3  6  7  7  8
     *  第六次交换  0  1  2  2  3  6  7  7  8
     *  第七次交换  0  1  2  2  3  6  7  7  8
     *  第八次交换  0  1  2  2  3  6  7  7  8
     *  第九次交换  0  1  2  2  3  6  7  7  8
     *
     *     无论数据如何排列，所需比较次数都为 n(n-1)/2
     *     时间复杂度是O(n^2)
     *     简单选择排序是不稳定排序。
     *
     *  </pre>
     *
     * @author weikeqin.cn@gmail.com
     */
    public static int[] selectionSort(int[] arr){

        int length = arr.length;
        int tmp = 0;
        for(int i = 0; i < length; i++){
            //
            int index = selectMinKey(arr, i, length);
            System.out.println("数组下标："+index + "   对应元素："+arr[index]);

            // 交换值
            if(i != index){
                tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }

            print(arr);
        }

        return arr;
    }

    /**
     * 选出数组给定范围最小值对应的数组下标
     *
     * @param arr
     * @param begin
     * @param length
     */
    public static int selectMinKey(int[] arr, int begin, int length) {
        int minKey = 0;
        int index = 0;
        boolean first = true;
        for(int j = begin; j < length; j++){

            if(first){
                minKey = arr[j];
                index = j;
                first = false;
            }

            if(arr[j] < minKey){
                minKey = arr[j];
                index = j;
            }
        }

        return index;
    }

    /**
     * @param arr
     */
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] a = null;
        a = new int[]{2, 7, 8, 2, 7, 6, 1, 3, 0};
        //a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("---------------排序前--------------------");
        print(a);

        System.out.println("--------------开始排序--------------------");
        a = selectionSort(a);
        System.out.println("---------------排序后---------------------");
        print(a);
    }

}
