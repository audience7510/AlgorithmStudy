package LeetCode.链表.q148_排序链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/27
 * @Version 1.0
 * @Description
 * 思路：快慢指针找到链表中点，递归继续找中点，终止条件为
 *      当链表节点数小于或等于1时，即链表为空或只包含一个节点
 *      合并两个有序链表，merge方法采用迭代，merge2方法采用递归
 *      merge2与 q21_合并两个有序链表 一样，使用递归
 */
public class Solution {
    public ListNode sortList(ListNode head) {

        return sortList(head,null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null){
            return head;
        }
        //tail为null，或者为mid
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if (fast!=tail){
                fast = fast.next;
            }
        }
        //快慢指针找到中点
        ListNode mid = slow;
        //递归继续找中点，终止条件 当链表节点数小于或等于1时，即链表为空或只包含一个节点
        ListNode listNode1 = sortList(head, mid);
        ListNode listNode2 = sortList(mid, tail);
        ListNode sort = merge(listNode1,listNode2);
        return sort;
    }

    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode temp1 = listNode1;
        ListNode temp2 = listNode2;
        while (temp1!=null && temp2!=null){
            if (temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1!=null){
            temp.next = temp1;
        }else if (temp2!=null){
            temp.next = temp2;
        }
        return head.next;
    }

    public ListNode merge2(ListNode l1, ListNode l2) {
        //两个链表为升序，递归调用结束，谁先为null，链表到末尾了
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        //若l1小于l2，继续传入l1的下一个节点与l2进行比较
        //
        if (l1.val < l2.val){
            //当出栈时，l1较小，就将较大的l2拼接到l1的后面
            l1.next = merge2(l1.next, l2);
            //l1拼接完之后返回，用于下次出栈
            return l1;
        }else {
            //若l1大于等于l2，继续传入l2的下一个节点与l1进行比较
            //出栈时，将较大的l1拼接到l2的后面
            l2.next = merge2(l1,l2.next);
            //l2拼接完之后返回，用于下次出栈
            return l2;
        }
    }
}
