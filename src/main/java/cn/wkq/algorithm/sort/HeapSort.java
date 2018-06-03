package cn.wkq.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author: weikeqin.cn@gmail.com
 */
public class HeapSort {

    /**
     * 定义：完全二叉树中所有非终端节点的值不大于左右孩子节点的值
     * <p>
     * 操作过程如下：
     * <p>
     * 1.初始化堆：将R[0..n-1]构造为堆。
     * <p>
     * 2.将当前无序区的堆顶元素R[0]同该区间的最后一个记录R[n-1]交换，然后将新的无序区调整为新的堆。
     * <p>
     * 因此对于堆排序，最重要的两个操作就是构造初始堆和调整堆，其实构造初始堆事实上也是调整堆的过程， 只不过构造初始堆是对所有的非叶节点都进行调整。
     *
     * @param arr
     */
    private static void headSort(int[] arr) {

        int arrLength = arr.length;

        // 循环建堆
        for (int i = 0; i < arrLength - 1; i++) {

            // 建堆
            buileMaxHeap(arr, arrLength - 1 - i);

            // 交换堆顶和最后一个元素
            swap(arr, 0, arrLength - 1 - i);
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 对arr数组从0到lastIndex建大顶堆
     */
    private static void buileMaxHeap(int[] arr, int lastIndex) {

        // 从lastIndex处节点(最后一个节点)的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;

                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 如果右子节点的值较大
                    if (arr[biggerIndex] < arr[biggerIndex + 1]) {
                        // biggerIndex 总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                // 如果k节点的值小于其较大子节点的值
                if (arr[k] < arr[biggerIndex]) {

                    swap(arr, k, biggerIndex);

                    // 将biggerIndex赋予k，开始while循环的下一循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;

                } else {
                    break;
                }

            } // end while

        }// end for

    } // end method

    /**
     * 互换值
     */
    private static void swap(int[] arr, int k, int biggerIndex) {
        int tmp = arr[k];
        arr[k] = arr[biggerIndex];
        arr[biggerIndex] = tmp;
    }

    /**
     * 打印
     */
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] a = {2, 7, 8, 2, 7, 6, 1, 3, 0};
        int[] a2 = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        System.out.println("----------排序前--------------");
        print(a);

        headSort(a);

        System.out.println("----------排序后--------------");
        print(a);
    }

}
