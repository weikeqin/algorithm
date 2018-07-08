package cn.wkq.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author: weikeqin.cn@gmail.com
 */
public class HeapSort {

    /**
     * 堆排序
     *
     * 定义：完全二叉树中所有非终端节点的值不大于左右孩子节点的值
     * <pre>
     *
     * 操作过程如下：
     *   1.初始化堆：将R[0..n-1]构造为堆。
     *   2.将当前无序区的堆顶元素R[0]同该区间的最后一个记录R[n-1]交换，然后将新的无序区调整为新的堆。
     *     因此对于堆排序，最重要的两个操作就是构造初始堆和调整堆，其实构造初始堆事实上也是调整堆的过程，
     *     只不过构造初始堆是对所有的非叶节点都进行调整。
     * </pre>
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        System.out.println("-----初始构造大顶堆-----");
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
            print(arr);
        }


        System.out.println("-----调整大顶堆-----");
        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(arr, 0, i);

            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(arr, 0, i);

            print(arr);
        }
    }

    /**
     * 构建堆的过程
     *
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n
     */
    public static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
    }

    /**
     * 获取到左孩子结点
     *
     * @param i
     * @return
     */
    public static int leftChild(int i) {
        return 2 * i + 1;
    }


    /**
     * 交换元素位置
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
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

        int[] arr = {2, 7, 8, 2, 7, 6, 1, 3, 0};
        // arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
//        arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
//                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        System.out.println("排序之前：");
        print(arr);

        // 堆排序
        heapSort(arr);

        System.out.println("排序之后：");
        print(arr);
    }

}
