package LeetCode.链表.q234_回文链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/9
 * @Version 1.0
 * @Description
 * 思路：快慢指针寻找中间节点，快指针一次走两步，慢指针一次走一步
 *      当快指针遍历结束，慢指针就是中间节点
 *      将链表切成两段，将后半段链表翻转，遍历两个链表比较是否相等
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null   ){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //快慢指针遍历
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //偶数节点，让慢指针向后一位
        if (fast != null) {
            slow = slow.next;
        }
        //遍历结束，慢指针为中间节点
        //将链表切成两段
        cut(head,slow);
        //将后半段链表翻转
        ListNode reverse = getReverse(slow);
        boolean equal = isEqual(head, reverse);
        return equal;
    }
    public ListNode getReverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = getReverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public void cut(ListNode head, ListNode cutNode) {
        while (head.next!=cutNode){
            head = head.next;
        }
        head.next = null;
    }
    public boolean isEqual(ListNode l1, ListNode l2) {
        while (l1!=null && l2!=null){
            if (l1.val != l2.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
