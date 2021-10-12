package LeetCode.链表.q23_合并K个升序链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/8
 * @Version 1.0
 * @Description
 * 思路：分治。将k个链表配对，并将同一对中的链表合并。
 *      第一次合并，k个被合并成 k/2 个链表，第二次 k/4，第三次 k/8等等以此类推
 *      重复这个过程，直到得到有序链表
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = merge(lists, 0, lists.length - 1);
        return listNode;
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        //取中，二进制位右移1位
        //int mid = (l + r) >> 1;
        int mid = l + (r - l) / 2;
        //此方法递归，12 34 56，假设六个，那么方法最终出栈时，1和2合并，3和4合并，5和6合并
        //得到合并后的链表 继续出栈进行合并
        ListNode listNode = mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        return listNode;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        //用于节点后移
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}