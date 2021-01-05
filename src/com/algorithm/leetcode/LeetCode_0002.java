package com.algorithm.leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 **/
public class LeetCode_0002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = new ListNode(0, l1);
        ListNode h2 = new ListNode(0, l2);
        ListNode node = null, node1 = null;
        int c = 0;
        int count = 0;
        while (h1.next != null || h2.next != null) {
            count++;
            int a = 0;
            int b = 0;
            if (h1.next != null) {
                a = h1.next.val;
                h1 = h1.next;
            }
            if (h2.next != null) {
                b = h2.next.val;
                h2 = h2.next;
            }

            int val = a + b + c;
            if (val >= 10) {
                c = val / 10;
                val = val - 10;
            } else {
                c = 0;
            }
            if (count == 1) {
                node = new ListNode(val);
                node1 = node;
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        if (c != 0) {
            node.next = new ListNode(c);
        }
        return node1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
