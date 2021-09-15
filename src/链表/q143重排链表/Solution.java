package 链表.q143重排链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/15
 * @Version 1.0
 * @Description
 * 思路：方法1，遍历链表，添加到list集合中，然后双指针从头和尾遍历集合，并交换节点的位置
 *      时间复杂度O(n)，空间复杂度O(n)
 *      方法2，(1)找到链表的中点，快慢指针法，慢一次走一步，快一次走两步
 *            (2)将链表的右半部分翻转，
 *            (3)合并链表
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ListNode mid = midNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        //断开mid.next之后，l1和l2成了两条链表了
        mid.next = null;
        l2 = reverseNode(l2);
        mergeNode(l1,l2);
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseNode(ListNode l2) {
        ListNode pre = null;
        ListNode cur = l2;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private void mergeNode(ListNode l1, ListNode l2) {
        ListNode temp1;
        ListNode temp2;
        while (l1!=null && l2!=null){
            //暂存两个链表的下一个节点
            temp1 = l1.next;
            temp2 = l2.next;
            //把l2放到l1的后面
            l1.next = l2;
            //l1后移
            l1 = temp1;
            //把后移的l1放到l2的后面
            l2.next = l1;
            //l2后移
            l2 = temp2;
        }
    }
}
