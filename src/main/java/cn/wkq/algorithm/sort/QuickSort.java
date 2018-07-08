package cn.wkq.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序<br>
 *     快速排序是对冒泡排序的一种改进
 *
 * <pre>
 *   基本思想：选择一个基准元素，通常选择第一个元素或者最后一个元素，
 *            通过一趟扫描， 将待排序列分成两部分，一部分比基准元素小，一部分大于等于基准元素,
 *            此时基准元素在其排好序后的正确位置，然后再用同样的方法递归地排序划分的两部分。
 * </pre>
 *
 * @author weikeqin.cn@gmail.com
 */
public class QuickSort {

    /**
     * <pre>
     *
     * 基本思想：选择一个基准元素，通常选择第一个元素或者最后一个元素，
     *          通过一趟扫描， 将待排序列分成两部分，一部分比基准元素小，一部分大于等于基准元素,
     *          此时基准元素在其排好序后的正确位置，然后再用同样的方法递归地排序划分的两部分。
     *
     * </pre>
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {

        if(end <= start){
            return ;
        }

        int i = start;
        int j = end;
        // 数组的第一个作为中轴/基准元素
        int pivot = arr[i];
        while (i < j) {

            // 比中轴大的在高端(右边)
            // 从右向左找小于x的数来填arr[i]
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if(i < j){
                // 比中轴/基准元素小的，移到低端/左边
                //将arr[j]填到arr[i]中，arr[j]就形成了一个新的坑
                arr[i] = arr[j];
            }

            // 比中轴元素小的在低端(左边)
            // 从左向右找大于或等于x的数来填arr[j]
            while (i < j && arr[i] < pivot) {
                i++;
            }

            if(i < j){
                // 比中轴大的，跳出while循环，移到高端/右边
                //将arr[i]填到arr[j]中，arr[i]就形成了一个新的坑
                arr[j] = arr[i];
            }
        }

        // 中轴记录到尾
        // 一次快速排序完，将pivot填到i这个坑中。
        arr[i] = pivot;

        quickSort(arr, start, i - 1);
        quickSort(arr, i+1, end);
    }


    public static int[] quickSortMy(int[] arr, int low, int high) {

        if (low >= high) {
            return new int[0];
        }

        // 进行一趟快速排序，将数组一分为二
        int middle = oneQuickSort(arr, low, high);
        print(arr);

        // 对低字表进行递归排序
        quickSortMy(arr, low, middle - 1);
        // 对高字表进行递归排序
        quickSortMy(arr, middle + 1, high);

        return arr;
    }

    /**
     * 进行一趟快速排序，将数组一分为二 <br>
     *
     * low 和 high 是指针，arr[low], arr[high]是值 操作指针，比较值
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int oneQuickSort(int[] arr, int i, int j) {

        // 数组的第一个作为中轴/基准元素
        int pivot = arr[i];
        while (i < j) {

            // 比中轴大的在高端(右边)
            // 从右向左找小于x的数来填arr[i]
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if(i < j){
                // 比中轴/基准元素小的，移到低端/左边
                //将arr[j]填到arr[i]中，arr[j]就形成了一个新的坑
                arr[i] = arr[j];
            }

            // 比中轴元素小的在低端(左边)
            // 从左向右找大于或等于x的数来填arr[j]
            while (i < j && arr[i] < pivot) {
                i++;
            }

            if(i < j){
                // 比中轴大的，跳出while循环，移到高端/右边
                //将arr[i]填到arr[j]中，arr[i]就形成了一个新的坑
                arr[j] = arr[i];
            }
        }

        // 中轴记录到尾
        // 一次快速排序完，将pivot填到i这个坑中。
        arr[i] = pivot;


        // 返回中轴的位置
        return i;
    }



    /**
     *
     * @param arr
     * @param head
     * @param tail
     */
    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }


    /**
     * @param arr
     */
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr1 = {2, 7, 8, 2, 7, 6, 1, 3, 0};
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] a3 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};

        System.out.print("--------------排序前---------------------");
        print(arr);

        // 快速排序
        quickSort(arr, 0, arr.length - 1);
        //quickSortMy(arr, 0, arr.length - 1);

        System.out.print("--------------排序后---------------------");
        print(arr);
    }

}
