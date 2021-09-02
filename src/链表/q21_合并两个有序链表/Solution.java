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
}
