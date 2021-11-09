package LeetCode.链表.q141_环形链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/1
 * @Version 1.0
 * @Description
 * 思路：快慢指针，慢指针一次走一步，快指针一次走两步，
 *      慢指针初始位置在head，快指针初始位置在head.next
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //循环条件判断两个节点是否相同，那么初始化的快慢节点不能同时为head
        while (slow!=fast){
            //快指针走到末尾了，说明没有环，返回false
            if (fast == null || fast.next == null){
                return false;
            }
            //一次一步
            slow = slow.next;
            //一次两步
            fast = fast.next.next;
        }
        return true;
    }
}
