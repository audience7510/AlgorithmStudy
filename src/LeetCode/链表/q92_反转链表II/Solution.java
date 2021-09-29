package LeetCode.链表.q92_反转链表II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/9
 * @Version 1.0
 * @Description
 * 思路：1、假设没有left和right，翻转整个链表，是q206这道题
 *      2、假设left=1，是反串前right个元素
 *      3、假设left!=1了，head.next索引作为1，那么相对于head.next，反转的区间是
 *         left-1到right-1(right-1是需要保证二者区间不变)，
 *         对于head.next.next，反转区间是left-2到right-2，以此类推
 *         直到left减为1了，head也移动到了left的位置，因为保持的left到right的区间不变
 *         所以已经变成了情况2
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            //此方法是翻转前n个节点
            return reverseN(head,right);
        }
        // 12345
        //left不断减1，直到head移动到left的位置，即left=1了，相当于翻转前n个节点
        //用head.next指向翻转后的节点
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    //用于记录递归到right==1 之后的节点
    ListNode res = null;
    private ListNode reverseN(ListNode head, int right) {
        if (right == 1){
            res = head.next;
            return head;
        }
        ListNode listNode = reverseN(head.next, right - 1);
        //翻转
        head.next.next = head;
        //翻转之后，拼接上right==1 之后的节点
        head.next = res;
        return listNode;
    }
}
