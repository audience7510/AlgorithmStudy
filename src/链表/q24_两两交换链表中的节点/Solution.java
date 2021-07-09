package 链表.q24_两两交换链表中的节点;

/**
 * @ClassName Program
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description   12345
 * 思路：双指针 头节点和2节点交换，交换之后2节点变成了头结点，
 *      头节点要和剩下的链表进行连接,最后再把2和1连接起来
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        //节点互换
        head = second;
        //老的头节点指向互换之后的节点
        first.next = swapPairs(second.next);
        //新头节点的next指向老的头节点
        second.next = first;
        return head;
    }
}
