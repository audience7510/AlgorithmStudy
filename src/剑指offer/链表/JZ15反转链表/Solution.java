package 剑指offer.链表.JZ15反转链表;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/29
 * @Version 1.0
 * @Description
 */
public class Solution {
    /**
     * @Date 2021/9/30
     * @Param [head]
     * @return
     * @Description 递归实现
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //暂存当前节点的下一个节点
        ListNode temp = head.next;
        //递归
        ListNode listNode = ReverseList(head.next);
        //反转
        temp.next = head;
        //断开节点
        head.next = null;
        return listNode;
    }

    /**
     * @Date 2021/9/30
     * @Param [head]
     * @return
     * @Description 迭代实现
     */
    public ListNode ReverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head!=null){
            //暂存next节点
            next = head.next;
            //反转
            head.next = pre;
            //更新pre的值
            pre = head;
            //更新head的值
            head = next;
        }
        return pre;
    }
}
