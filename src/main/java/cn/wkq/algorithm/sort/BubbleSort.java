package cn.wkq.algorithm.sort;


import java.util.Arrays;

/**
 * 冒泡排序<br>
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到 数列 的顶端，故名。<br>
 * <p>
 * 冒泡排序最好的时间复杂度为O(n)，最坏时间复杂度为O(n^2)<br>
 * 综上，因此冒泡排序总的平均时间复杂度为 O(n^2)
 *
 * References
 * https://www.cnblogs.com/melon-h/archive/2012/09/20/2694941.html
 *
 * @author: weikeqin.cn@gmail.com
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * <pre>
     *
     * 在数列里把小的往上浮就相当于把小的往(数组)前放
     *
     * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整， 让较大的数往上浮，较小的往下。
     * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     *
     * 在这个方法里(未改进)，冒泡排序最好的时间复杂度为O(n^2) 冒泡排序的最坏时间复杂度为O(n^2)
     *
     * 原理：假如有一个长度为n的数组，要循环n-1次 每次循环把最大值换到第一个位置
     *
     * 例子： 28276130 长度n=9;要循环8次
     * 第一次循环完 变成 2 7 2 7 6 1 3 0 8
     * 第二次循环完 变成 2 2 7 6 1 3 0 7 8
     * 第三次循环完 变成 2 2 6 1 3 0 7 7 8
     * 第四次循环完 变成 2 2 1 3 0 6 7 7 8
     * 第五次循环完 变成 2 1 2 0 3 6 7 7 8
     * 第六次循环完 变成 1 2 0 2 3 6 7 7 8
     * 第七次循环完 变成 1 0 2 2 3 6 7 7 8
     * 第八次循环完 变成 0 1 2 2 3 6 7 7 8
     * </pre>
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //int count = 0;
        int arrLength = arr.length;
        // 比多少趟
        for (int i = 0; i < arrLength - 1; i++) {
            // 一趟比多少次
            for (int j = 0; j < arrLength - i - 1; j++) {

                // 相邻元素比较，小的往前放，大的往后放
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }

            } // end for

            print(arr);

        } // end for
    } // end method

    /**
     * 交换数组元素
     *
     * @param arr
     * @param big
     * @param small
     */
    public static void swap(int[] arr, int big, int small) {
        int tmp = 0;
        tmp = arr[big];
        arr[big] = arr[small];
        arr[small] = tmp;
    }


    /**
     * 改进版的冒泡排序<br>
     *
     * 改进版的冒泡排序最好的时间复杂度为O(n) 冒泡排序的最坏时间复杂度为O(n^2)
     *
     * @param arr
     */
    public static void bubbleSortImprove(int[] arr) {
        int arrLength = arr.length;
        // 比多少趟
        boolean didSwap = false;
        for (int i = 0; i < arrLength - 1; i++) {

            // 一趟比多少次
            for (int j = 0; j < arrLength - i - 1; j++) {
                // 相邻元素比较，小的往前放，大的往后放
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    didSwap = true;
                }
            } // end for

            //print(arr);
            if(didSwap == false){
                return;
            }

        } // end for
    } // end method

    /**
     *
     * @param arr
     */
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param args
     * @author weikeqin.cn@gmail.com
     * @date 2018/6/2 15:35
     */
    public static void main(String[] args) {

        int[] a = null;
        a = new int[]{2, 7, 8, 2, 7, 6, 1, 3, 0};
        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

//        int count = 100000;
//        a = new int[count];
//        for(int i = 0; i < count; i++){
//            // 倒序
//            //a[i] = count - i;
//            // 正序
//            a[i] = i;
//        }

        System.out.println("---------------排序前--------------------");
        print(a);

        System.out.println("--------------开始排序--------------------");
        long start = System.currentTimeMillis();
        // 冒泡排序
        bubbleSortImprove(a);
        long end = System.currentTimeMillis();
        System.out.println("共花费" + 1.0 * (end - start) / 1000 + "s");

        System.out.println("---------------排序后---------------------");
        print(a);

    }

}
