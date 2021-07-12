package 链表.q21_合并两个有序链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：两个链表头部较小的一个，指向递归出来的较大节点
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //递归调用结束，谁先为null，则说明另一个链表，升序的值较大
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        //递归调用结束，返回最后一个最大值，用第二大的节点 指向最大的节点
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
