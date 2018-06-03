package cn.wkq.algorithm.sort;

import java.util.Arrays;

/**
 * 直接插入排序 <br>
 *
 * References
 * https://www.cnblogs.com/chengxiao/p/6103002.html
 * https://www.cnblogs.com/skywang12345/p/3596881.html
 *
 * @author: weikeqin.cn@gmail.com
 */
public class StraightInsertionSort {

    /**
     * 直接插入排序<br>
     *
     * <pre>
     *      基本思想： 把n个待排序的元素看成为一个有序表和一个无序表。
     *        开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
     *        排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，
     *        使之成为新的有序表，重复n-1次可完成排序过程。
     *
     *   数据 2  7  8  2  7  6  1  3  0
     *   假设有序表里有一个元素，是数组的第一个元素，其他的元素在无序表里，逐个插入
     *   插入时如果相等，要插入的元素放到当前元素的后面
     *
     *   第一次插入 2  7
     *   第二次插入 2  7  8
     *   第三次插入 2  2  7  8
     *   第四次插入 2  2  7  7  8
     *   第五次插入 2  2  6  7  7  8
     *   第六次插入 1  2  2  6  7  7  8
     *   第七次插入 1  2  2  3  6  7  7  8
     *   第八次插入 0  1  2  2  3  6  7  7  8
     *
     *   最好情况要比较n-1次，最差情况要比较 n(n-1)/2
     *   时间复杂度是 O(n^2)
     *
     *  </pre>
     *
     * @param arr
     * @author weikeqin.cn@gmail.com
     */
    public static int[] starightInsertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            // 把 选择数组下标 和 插入数据时元素后移 合二为一
            while (j > 0 && arr[j] < arr[j - 1]) {
                // 插入排序采用交换法
                swap(arr, j, j - 1);
                j--;
            }
        }
        return arr;
    }


    /**
     * 直接插入排序<br>
     *    第一次自己实现的
     *
     * @param arr
     * @author weikeqin.cn@gmail.com
     */
    public static int[] starightInsertionSortMy(int[] arr) {

        int length = arr.length;
        // 要插入的位置
        int index = 0;
        int tmp = 0;
        // 以数组第一个元素作为有序表，其他元素作为无序表
        // 最小的放前面，大的放后面，如果等于，等于的全部放到后面
        for (int i = 1; i < length; i++) {

            if (arr[i] < arr[i - 1]) {

                System.out.println("第" + i + "个元素" + arr[i] + "小于第" + (i - 1) + "个元素" + arr[i - 1] + "    准备插入。");
                // 寻找插入位置，从小到大找
                if (arr[i] < arr[0]) {
                    index = 0;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (arr[i] >= arr[j] && arr[i] < arr[j + 1]) {
                            // 要插入到j+1个位置
                            index = j + 1;
                        }
                    }
                }
                System.out.println("第" + i + "个元素" + arr[i] + "准备插入到第" + index + "个位置。");
                System.out.println("第" + index + "个元素到第" + (i - 1) + "个元素全部往右移。");

                tmp = arr[i];
                // 插入有序表对应位置，index位置及以后的全部后移
                for (int k = i - 1; k >= index; k--) {
                    System.out.println("第" + k + "个元素" + arr[k] + "移动到到第" + (k + 1) + "个位置。");
                    arr[k + 1] = arr[k];
                }
                arr[index] = tmp;
            } else {
                // 如果 arr[i] >= arr[i-1]，arr[i]插入到arr[i-1]后面，也就是位置不变
                System.out.println("第" + i + "个元素" + arr[i] + "大于第" + (i - 1) + "个元素" + arr[i - 1] + "    不用插入。");
            }

            // 打印当前数组
            print(arr);
        }

        return arr;
    }


    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swapUseCpu(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int tmp = 0;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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
        a = starightInsertionSort(a);
        System.out.println("---------------排序后---------------------");
        print(a);
    }

}
