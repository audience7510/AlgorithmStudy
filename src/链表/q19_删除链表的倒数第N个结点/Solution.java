package 链表.q19_删除链表的倒数第N个结点;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：双指针，第一个指针从链表头开始，第二个指针从头向后移动n步，
 *      当第二个指针遍历到末尾时，此时第一个指针在倒数第n-1个节点
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = head.next;
        }
        if (fast == null){
            return head;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
