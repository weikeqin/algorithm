package cn.wkq.algorithm;

import org.junit.Test;

/**
 * 最大连续子序列和
 *  动态规划
 *
 * <pre>
 *     给定K个整数的序列{ N1, N2, …, NK }，其任意连续子序列可表示为{ Ni, Ni+1, …, Nj }，其中 1 <= i <= j <= K。
 *     最大连续子序列是所有连续子序中元素和最大的一个。
 *
 *     例如给定序列{-2, 11, -4, 13, -5, -2}，其最大连续子序列为{11, -4, 13}，最大和为20。
 *
 *  References:
 *     最大连续子序列和    https://blog.csdn.net/sgbfblog/article/details/8032464
 *
 * </pre>
 *
 * @author: weikeqin.cn@gmail.com
 * @date: 2018-07-08 9:54
 */
public class MaxSequence {

    /**
     * <pre>
     *     O(N^2) 解法
     *     暴力破解
     *
     *     因为最大连续子序列和只可能从数组0到n-1中某个位置开始，
     *     我们可以遍历0到n-1个位置，计算由这个位置开始的所有连续子序列和中的最大值。
     *     最终求出最大值即可。
     *
     *     更详细的讲，
     *     就是计算从位置0开始的最大连续子序列和，从位置1开始的最大连续子序列和 ... 从位置n-1开始的最大连续子序列和，
     *     最后比较所有这些连续子序列和中的最大值就是答案。
     *
     * </pre>
     *
     * @param arr
     * @param len
     * @return
     */
    int maxsequence(int[] arr, int len) {
        //初始化最大值为第一个元素
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            //sum必须清零
            int sum = 0;
            //从位置i开始计算从i开始的最大连续子序列和的大小，如果大于max，则更新max。
            for (int j = i; j < len; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 解法2—O（NlgN）解法
     *
     * <pre>
     *   该问题还可以通过分治法来求解，
     *   最大连续子序列和要么出现在数组左半部分，要么出现在数组右半部分，要么横跨左右两半部分。
     *   因此求出这三种情况下的最大值就可以得到最大连续子序列和。
     * </pre>
     *
     * @param arr
     * @param l
     * @param u
     * @return
     */
    int maxsequence2(int[] arr, int l, int u) {
        if (l > u) {
            return 0;
        }
        if (l == u) {
            return arr[l];
        }
        int m = (l + u) / 2;

        /**求横跨左右的最大连续子序列左半部分*/
        int lmax = arr[m], lsum = 0;
        for (int i = m; i >= l; i--) {
            lsum += arr[i];
            if (lsum > lmax) {
                lmax = lsum;
            }
        }

        /**求横跨左右的最大连续子序列右半部分*/
        int rmax = arr[m + 1], rsum = 0;
        for (int i = m + 1; i <= u; i++) {
            rsum += arr[i];
            if (rsum > rmax) {
                rmax = rsum;
            }
        }
        //返回三者最大值
        return max3(lmax + rmax, maxsequence2(arr, l, m), maxsequence2(arr, m + 1, u));
    }

    /**
     * 求三个数最大值
     */
    int max3(int i, int j, int k) {
        if (i >= j && i >= k) {
            return i;
        }
        return max3(j, k, i);
    }

    /**
     *   解法3 — O(N)解法
     *
     * <pre>
     *     还有一种更好的解法，只需要O(N)的时间。
     *     因为最大 连续子序列和只可能是以位置0～n-1中某个位置结尾。
     *     设 阀值为x
     *     当遍历到第i个元素时，判断在它前面的连续子序列和是否大于x，
     *     如果大于x，则以位置i结尾的最大连续子序列和为元素i和前门的连续子序列和相加；
     *     否则，则以位置i结尾的最大连续子序列和为元素i。
     *
     *      这儿为了方便，用阀值=0，其实阀值是多少都行，对程序没影响
     * </pre>
     *
     * @param arr
     * @param len
     * @return
     */
    public int maxsequence3(int[] arr, int len) {
        int maxsum, maxhere;
        //初始化最大和为a[0]
        maxsum = maxhere = arr[0];
        for (int i = 1; i < len; i++) {
            if (maxhere <= 0) {
                //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
                maxhere = arr[i];
            } else {
                //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
                maxhere += arr[i];
            }

            // 如果 arr[n] > arr[m]+arr[m+1] +...+arr[n-1]，(m<n) 更新最大连续子序列和，否则不更新
            // 如果 arr[m]+arr[m+1] +...+arr[n-1]+arr[n] > arr[m]+arr[m+1] +...+arr[n-1]，(m<n) 更新最大连续子序列和，否则不更新
            if (maxhere > maxsum) {
                //更新最大连续子序列和
                maxsum = maxhere;
            }
        }
        return maxsum;
    }

    @Test
    public void testMaxSwquence3(){
        //int[] arr = {-2, 11, -4, 13, -5, -2};
        int[] arr = {-2, -11, -4, -13, -5, -2};
        int result = maxsequence3(arr, arr.length);
        System.out.println(result);
        //log.info(result);
    }

}
