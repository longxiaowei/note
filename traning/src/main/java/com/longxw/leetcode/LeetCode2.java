package com.longxw.leetcode;

import lombok.Data;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author longxw
 * @since 2020/4/14
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode current = node;
        int temp = 0;

        while(l1 != null || l2 != null || temp != 0) {
            int l1_data = l1 != null ? l1.data : 0;
            int l2_data = l2 != null ? l2.data : 0;
            int sum = l1_data + l2_data + 0;
            temp = sum / 10;

            ListNode tempNode = new ListNode();
            tempNode.data = sum % 10;
            current.next = tempNode;

            current = tempNode;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return node;
    }

    class ListNode{
        private Integer data;
        private ListNode next;
        public void add(Integer data){
            if (this.data == null){
                this.data = data;
            }else{
                ListNode listNode = new ListNode();
                listNode.add(data);
                this.next = listNode;
            }

        }
    }
}
