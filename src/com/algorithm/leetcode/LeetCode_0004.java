package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 **/
public class LeetCode_0004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {


        return 0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] num = new int[len1 + len2];
        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            if (nums1[i] > nums2[j]) {
                num[k] = nums2[j];
                j++;
            } else {
                num[k] = nums1[i];
                i++;
            }
            k++;
        }

        if (i < len1) {
            for (int ii = i; ii < len1; ii++) {
                num[k++] = nums1[ii];
            }
        }

        if (j < len2) {
            for (int jj = j; jj < len2; jj++) {
                num[k++] = nums2[jj];
            }
        }
        //System.out.println(Arrays.toString(num));
        if (num.length % 2 == 0) {
            return (num[num.length / 2] + num[num.length / 2 - 1]) / 2.0;
        }
        return num[num.length / 2];
    }
}
