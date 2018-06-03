package cn.wkq.algorithm.sort;

import java.util.Arrays;

/**
 * @author weikeqin.cn@gmail.com
 */
public class QuickSort {


    /**
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描， 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
     * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     *
     * @param arr
     */
    private static int[] quickSort(int[] arr) {

        if (!(arr.length > 0)) {
            System.err.println("数组长度不能为0，请修改");
            return new int[0];
        }

        return quickSort(arr, 0, arr.length - 1);

    }

    /**
     * <pre>
     *
     *   基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
     *            将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
     *            此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     *
     * </pre>
     *
     * @param arr
     * @param low
     * @param high
     */
    private static int[] quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return new int[0];

        }

        // 将数组一分为二
        int middle = getMiddle(arr, low, high);
        // 对低字表进行递归排序
        quickSort(arr, low, middle - 1);
        // 对高字表进行递归排序
        quickSort(arr, middle + 1, high);

        return arr;
    }

    /**
     * 将数组一分为二
     * <p>
     * low 和 high 是指针，arr[low], arr[high]是值 操作指针，比较值
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int getMiddle(int[] arr, int low, int high) {

        // 数组的第一个作为中轴/基准元素
        int tmp = arr[low];
        // low 和 high 是指针
        while (low < high) {

            // 比中轴大的在高端(右边)，不用动，执行下一个
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 比中轴/基准元素小的，跳出wehile循环，移到低端/左边
            arr[low] = arr[high];

            // 此时arr[low]的大小变了

            // 比中轴元素小的在低端(左边)，不用动，执行下一个
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 比中轴大的，跳出while循环，移到高端/右边
            arr[high] = arr[low];
        }

        // 中轴记录到尾
        arr[low] = tmp;

        // 返回中轴的位置
        return low;
    }


    // main
    public static void main(String[] args) {

        int[] a = {2, 7, 8, 2, 7, 6, 1, 3, 0};
        int[] a2 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        System.out.print("--------------排序前---------------------");
        print(a2);

        // 快速排序
        quickSort(a2);

        System.out.print("--------------排序后---------------------");
        print(a2);
    }

    /**
     * @param arr
     */
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}
