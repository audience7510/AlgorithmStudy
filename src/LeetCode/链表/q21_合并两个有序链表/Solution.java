package LeetCode.链表.q21_合并两个有序链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：两个链表头部较小的一个，指向递归出来的较大节点
 */
public class Solution {
    /**
     * @Date 2021/10/8
     * @Param [l1, l2]
     * @return
     * @Description 递归方式
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
            l1.next = mergeTwoLists(l1.next, l2);
            //l1拼接完之后返回，用于下次出栈
            return l1;
        }else {
            //若l1大于等于l2，继续传入l2的下一个节点与l1进行比较
            //出栈时，将较大的l1拼接到l2的后面
            l2.next = mergeTwoLists(l1,l2.next);
            //l2拼接完之后返回，用于下次出栈
            return l2;
        }
    }

    /**
     * @Date 2021/10/8
     * @Param [l1, l2]
     * @return
     * @Description 迭代方式
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        //用于节点后移
        ListNode prev = preHead;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 ==null? l2:l1;
        return preHead.next;
    }
}
